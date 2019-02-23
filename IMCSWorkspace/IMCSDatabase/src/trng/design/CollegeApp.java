package trng.design;

public class CollegeApp {

	public static void main(String[] args) {
		Student student = new Student();
		College college = new College(student);
		System.out.println(college);
		college = null;
		College college2 = new College(student);
		System.out.println(college);
	}

}
