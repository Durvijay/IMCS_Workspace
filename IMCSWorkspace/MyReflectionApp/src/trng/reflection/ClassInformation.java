package trng.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.lang.reflect.Modifier;

/**
 * Display class information using Reflection API.
 * 
 * @author Manohar
 *
 */
public class ClassInformation {
	public static void main(String... args) throws ClassNotFoundException {
		System.out.println("Enter the class name:");
//		Class claz = Class.forName(new Scanner(System.in).next());
		Class claz = Employee.class;

		Annotation[] annotations = claz.getAnnotations();
		Method[] methods = claz.getMethods();
		Field[] fields = claz.getDeclaredFields();

		display("annotations", annotations);
		display("methods :", methods);
		display("fields : ", fields);
		
		
		int modifiers = claz.getModifiers();
	    System.out.println(" isAbstract: "  + Modifier.isAbstract(modifiers));
	    System.out.println(" isFinal " + Modifier.isFinal(modifiers));
	    System.out.println(" Interface: " + Modifier.isInterface(modifiers));
	    System.out.println(" Native " + Modifier.isNative(modifiers));
	    System.out.println(" Private " + Modifier.isPrivate(modifiers));
	    System.out.println(" Protected : " + Modifier.isProtected(modifiers));
	    System.out.println(" isPublic " + Modifier.isPublic(modifiers));
	    System.out.println(" isStatic " + Modifier.isStatic(modifiers));
	    System.out.println(" isStrict " + Modifier.isStrict(modifiers));
	    System.out.println(" isSynchronized " + Modifier.isSynchronized(modifiers));
	    System.out.println(" isTransient " + Modifier.isTransient(modifiers));
	    System.out.println(" isVolatile " + Modifier.isVolatile(modifiers));
	    
	    System.out.println(" Package : " + claz.getPackage());
	    System.out.println(" CanonicalName : " + claz.getCanonicalName());
	}

	private static void display(String infoString, Object[] infos) {
		System.out.println("\n\n******** " + infoString + " *******");

		if (infos == null) {
			return;
		}

		for (Object object : infos) {
			System.out.println(object);
		}
	}
}
