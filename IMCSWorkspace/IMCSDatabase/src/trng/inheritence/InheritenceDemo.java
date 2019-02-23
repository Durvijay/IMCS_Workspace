package trng.inheritence;

import java.util.Scanner;

import trng.inheritence.prsn.Person;
import trng.inheritence.prsn.Student;

public class InheritenceDemo {
	public static void main(String args[]) {
		 usage1();
//		usage2();
	}

	//Compile time poly
	static void usage1() {
		// coding in terms of abstract classes
		Person student = new Student("Dove", "Female", 123, 45);
		Person employee = new Employee("Pankaj", "Male", 102, 5000);

		student.eat();
		employee.eat();

		// using method implemented in abstract class - inheritance
		employee.display();
		student.display();
	}

	//Runtime poly
	static void usage2() {
		// coding in terms of abstract classes
		Person person = null;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Input (Employee/Student");
			String input = scanner.nextLine();
	
			switch (input) {
			case "Student":
				person = new Student("Dove", "Female", 123, 50);
				break;
			case "Employee":
				person = new Employee("Pankaj", "Male", 102, 5000);
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			person.eat();
			person.display();
			
			System.out.println("Do you want continue (Yes/No): ");
		} while(scanner.nextLine().equalsIgnoreCase("Yes"));
	}
}
