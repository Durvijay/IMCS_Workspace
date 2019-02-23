package trng.inheritence.abstrct;

import java.util.Scanner;

//abstract class
abstract class Person {

	private String name;
	private String gender;

	public Person(String nm, String gen) {
		this.name = nm;
		this.gender = gen;
	}

	// abstract method
	public abstract void eat();

	public void display() {
		System.out.println("Person information: ");
		System.out.println(" Name : " + name);
		System.out.println(" Gender : " + gender);
	}

	@Override
	public String toString() {
		return "Name=" + this.name + "::Gender=" + this.gender;
	}

}

class Employee extends Person {
	private int empId;
	private float salary;

	public Employee(String nm, String gen, int id, float salary) {
		super(nm, gen);
		empId = id;
		this.salary = salary;
	}

	@Override
	public void eat() {
		System.out.println("employee eating");
	}

	@Override
	public void display() {
		System.out.println("Employee information: ");
		// System.out.println(" Name : " + name); //Can't access private members
		// directly.
		super.display();
		System.out.println(" EmpId : " + empId);
		System.out.println(" Salary : " + salary);
	}
}

class Student extends Person {

	private int studentId;

	public Student(String nm, String gen, int id) {
		super(nm, gen);
		this.studentId = id;
	}

	@Override
	public void eat() {
		System.out.println("student eating");
	}

	public int getStudentId() {
		return studentId;
	}
}

public class AbstractClassDemo {
	public static void main(String args[]) {
		// usage1();
		usage2();
	}

	static void usage1() {
		// coding in terms of abstract classes
//		Person person = new Person("Raj", "Male");
		Person student = new Student("Dove", "Female", 123);
		Person employee = new Employee("Pankaj", "Male", 102, 5000);

		student.eat();
		employee.eat();

		// using method implemented in abstract class - inheritance
		employee.display();
		student.display();
	}

	static void usage2() {
		// coding in terms of abstract classes
		Person person = null;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Input (Employee/Student");
			String input = scanner.nextLine();
	
			switch (input) {
			case "Student":
				person = new Student("Dove", "Female", 123);
				break;
			case "Employee":
				person = new Employee("Pankaj", "Male", 102, 5000);
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			
			if(person != null) {
				person.eat();
				person.display();
			}
			
			System.out.println("Do you want continue (Yes/No): ");
		} while(scanner.nextLine().equalsIgnoreCase("Yes"));
	}
}
