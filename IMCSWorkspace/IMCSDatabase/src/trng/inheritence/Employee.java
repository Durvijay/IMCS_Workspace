package trng.inheritence;

import trng.inheritence.prsn.Person;

public class Employee extends Person {
	private int empId;
	private float salary;

	public Employee(String nm, String gen, int id, float salary) {
		super(nm, gen);
		empId = id;
		this.salary = salary;
	}

	public Employee(int salary) {
		this.salary = salary;
	}
	
	@Override
	public void eat() {
		System.out.println("employee eating");
	}

	public void eat(String food) {
		System.out.println("Person eating : " + food);
	}
	
	public Employee compareSal(Employee other) {
		if(this.salary > other.salary) {
			return this;
		} else {
			return other;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + empId;
		result = prime * result + Float.floatToIntBits(salary);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		return true;
	}

	@Override
	public void display() {
		System.out.println("Employee information: ");
		// System.out.println(" Name : " + name); //Can't access private members
		// directly.
//		System.out.println("Name : " +  name);
		System.out.println("Color : " +  color);
//			System.out.println("Color : " +  gender);
		System.out.println(" EmpId : " + empId);
		System.out.println(" Salary : " + salary);
	}
}

