package trng.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Display class information using Reflection API.
 * 
 * @author Manohar
 *
 */
public class ClassInformation {
	public static void main(String... args) throws ClassNotFoundException {
		System.out.println("Enter the class name:");
		Class claz = Class.forName(new Scanner(System.in).next());
//		Class claz = Employee.class;

		Annotation[] annotations = claz.getAnnotations();
		Method[] methods = claz.getMethods();
		Field[] fields = claz.getDeclaredFields();

		display("annotations", annotations);
		display("methods :", methods);
		display("fields : ", fields);
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
