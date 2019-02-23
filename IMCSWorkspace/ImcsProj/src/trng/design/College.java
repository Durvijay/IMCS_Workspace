package trng.design;

public class College {
	Student students;
	Departments departments;
	
	public College(Student students) {
		departments = new Departments();
		this.students = students;
	}

	@Override
	public String toString() {
		return "College [students=" + students + ", departments=" + departments + "]";
	}
	
	
}
