package trng.design;

/*
Employee has one address
Department many employee working
SalaryGrade , any employee salary can be part of this grade
Address - holds address information.
add required functionalities in the classes.
*/
public class EISSystem {
	public static void main(String[] args) {
		Employee[] employees = new Employee[10];
		Department dept = new Department(employees);
		SalaryGrade[] salaryGrades = new SalaryGrade[10];
		String grade = SalaryGradCaculator.getGrade(salaryGrades, 1000);
	}
}

class Department {
	Employee[] employees;

	int deptNo;
	String departmentName;

	/*
	 * public Department(Employee[] employees) { this.employees = employees; }
	 */

	public Department(Employee[] employees) {
		this.employees = new Employee[100];
	}

	void addEmp() {

	}

	void delEmp() {

	}
}

class Address {
	private String streeNo;
	private String streetName;
}

// class Employee extends Address implements SalaryGrade { //Harsha
class Employee {
	private int empNo;
	private String name;
	private float salary;

	Department department;
	Address address;

	public Employee(Department department) {
		this.department = department;
	}

	void readEmployeeInfo() {

	}

	void displayEmployeeInfo() {

	}

	// setters
	// getters
}

class SalaryGrade {
	int minSalary;
	int maxSalary;
	String grade;

	public SalaryGrade(int minSalary, int maxSalary, String grade) {
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.grade = grade;
	}
}

class SalaryGradCaculator {
	public static String getGrade(SalaryGrade[] salaryGrades, int salary) {
		// salaryGrades , identify grade.
		return null;
	}
}