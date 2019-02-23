package trng.inheritence.prsn;

public class UpcastingAndDowncasting {
	public static void main(String[] args) {
		upcastingUsage();
		downcastingUsage();
	}

	/**
	 *  Note: downcasting must always be done manually:
	 */
	private static void downcastingUsage() {
		Person person = new Person();
		
//		Student student = (Student) person; //This down casting is error.
		
		Person person1 = new Student();
		Student student1 = (Student) person1; //This down casting is correct.

		
		methodForStudent(student1);
//		methodForStudent(person); //you can;t do this. Subclass variable can't reference the super class object.
	}

	private static void upcastingUsage() {
		Student student = new Student();
		Person person = student; //up casting.
		
		methodForPerson(person);
		methodForPerson(student);
	}
	
	private static void methodForPerson(Person person)
	{
		System.out.println("methodForPerson" + person);
	}
	
	private static void methodForStudent(Student student)
	{
		System.out.println("methodForPerson" + student);
	}
}
