package trng.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

public class ReflectUtilAPI {
	
	public static final String CLASS_KEY = "class";
	public static final String METHOD_KEY = "methods";
	public static final String FIELD_KEY = "fields";
	public static final String MULTIPLE_VALUES_DELIMITER_SEMICOLN = ";";
	public static final String NAME_VALUE_DELIMITER_DBL_HASH = "##";
	public static final String TYPE_VALUES_DELIMITER_SNGL_HASH = "#";
	
	
	
	public Object constructObject(File file) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		
		//Construct object
		String classString = properties.getProperty("class").trim();
		Class<?> claz = Class.forName(classString);
		Object object = claz.newInstance();
		
		//Initialize object
		initializeObject(claz, object, properties);

		//Invoke method
		invokeMethods(claz, object, properties);
		
		return object;
	}
	
	
	private void invokeMethods(Class<?> claz, Object object,
			Properties properties) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		//Ex: methods=setName#String#int#float##Raj&12&12.4,;setSalary,float,1000
		//Initialize object
		
		
		if (properties.getProperty(METHOD_KEY) == null || properties.getProperty(METHOD_KEY).isEmpty()) return;
		
		String methodString = properties.getProperty(METHOD_KEY).trim();
		StringTokenizer tokenizer = new StringTokenizer(methodString, MULTIPLE_VALUES_DELIMITER_SEMICOLN);
				
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			String[] methodNameTypeAndValues = token.split(NAME_VALUE_DELIMITER_DBL_HASH);
			Class<?>[] parameterTypes = getMethodParameterTypes(methodNameTypeAndValues[1]);
			Object[] parameterValues = getMethodValues(methodNameTypeAndValues[1]);
			Method method = claz.getMethod(methodNameTypeAndValues[0], parameterTypes);
			method.invoke(object, parameterValues);
		}
	}

	//setName##String,float#Raj,12;setSalary##float,1000
	private Object[] getMethodValues(String methodTypeAndValueStr) throws ClassNotFoundException {
		
		if (methodTypeAndValueStr == null || methodTypeAndValueStr.isEmpty()) {
			return new Object[0];
		}
		
		String[] methodTypeAndValues = methodTypeAndValueStr.split(TYPE_VALUES_DELIMITER_SNGL_HASH);
		String[] methodTypes = methodTypeAndValues[0].split(",");
		String[] methodValues = methodTypeAndValues[1].split(",");
		List<Object> methodValueList = new ArrayList<>();
		for (int i = 0; i < methodTypes.length; i++) {
			methodValueList.add(StringToTypeParser.toObject(Class.forName(methodTypes[i]), methodValues[i]));
		}
		
		return methodValueList.toArray();
	}


	private Class<?>[] getMethodParameterTypes(String methodNameTypeAndValues) throws ClassNotFoundException {
		
		if (methodNameTypeAndValues == null || methodNameTypeAndValues.isEmpty()) {
			return new Class[0];
		}
		
		String[] methodTypeAndValues = methodNameTypeAndValues.split(TYPE_VALUES_DELIMITER_SNGL_HASH);
		String[] types = methodTypeAndValues[0].split(",");
		List<Class<?>> list = new ArrayList<>();
		for (String classString : types) {
			list.add(Class.forName(classString));
//			list.add(StringToTypeParser.toType(classString));
		}
		
		return list.toArray(new Class<?>[0]);
	}


	private void initializeObject(Class claz, Object object, Properties properties) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		//Initialize object
		
		String fieldString = properties.getProperty(FIELD_KEY);
		if (fieldString == null || fieldString.isEmpty()) {
			return;
		}
		
		fieldString = fieldString.trim();
		
		StringTokenizer tokenizer = new StringTokenizer(fieldString, MULTIPLE_VALUES_DELIMITER_SEMICOLN);
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			String[] fieldNameAndValue = token.split(NAME_VALUE_DELIMITER_DBL_HASH);
			Field field = claz.getField(fieldNameAndValue[0]);
			Class<?> type = field.getType();
			
			field.set(object,  StringToTypeParser.toObject(type, fieldNameAndValue[1]));
		}
	}
}
