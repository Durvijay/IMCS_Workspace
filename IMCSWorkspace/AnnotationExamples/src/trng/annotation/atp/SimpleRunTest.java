package trng.annotation.atp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import trng.annotation.Test;
import trng.annotation.use.TestExample;

public class SimpleRunTest {
	public static void main(String[] args) throws Exception {

		System.out.println("Test information...");

		Class<TestExample> claz = TestExample.class;

		// Process @Test
		for (Method method : claz.getDeclaredMethods()) {

			// if method is annotated with @Test
			if (method.isAnnotationPresent(Test.class)) {

				Annotation annotation = method.getAnnotation(Test.class);
				Test test = (Test) annotation;

				if (test.enabled()) {
					System.out.printf("\n%s - enabled", method.getName());
				} else {
					System.out.printf("\n%s - disabled", method.getName());
				}

			}

		}
	}
}
