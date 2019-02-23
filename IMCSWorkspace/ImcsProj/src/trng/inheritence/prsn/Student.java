package trng.inheritence.prsn;

public class Student extends Person {

	private int studentId;
	private int marks;

	public Student(String nm, String gen, int id, int marks) {
		super(nm, gen);
		this.studentId = id;
		this.marks = marks;
	}
		
	public Student() {
		
	}

	@Override
	public void eat() {
		System.out.println("student eating");
	}

	public int getStudentId() {
		return studentId;
	}
	
	public void display() {
//		System.out.println("Name : " +  name);
//		System.out.println("Color : " +  color);
//		System.out.println("Color : " +  gender);
		
		System.out.println("StudentId: " +  studentId);
		System.out.println("Marks : " +  marks);
		super.display();		
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}