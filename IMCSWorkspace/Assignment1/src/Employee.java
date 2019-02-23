

public class Employee {
	private String number;
	private String name;
	private double salary;
	
	
	public Employee(String number, String name, double salary) {
		this.number = number;
		this.name = name;
		this.salary = salary;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getHRAValue(){
		return salary*0.2;
		
	}
	@Override
	public String toString() {
		return "Employee Number: " + number + ", Employee Name :" + name + ", Employee Salary=" + salary ;
	}
	
	
}
