package trng.reflection;

import java.io.File;

public class ReflectionUsage {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Manohar\\workspace-training-advJava\\MyReflectionApp\\src\\BookClassInfo.txt");
		ReflectUtilAPI reflectUtilAPI = new ReflectUtilAPI();
		Object object = reflectUtilAPI.constructObject(file);
		System.out.println(object);
	}
}
