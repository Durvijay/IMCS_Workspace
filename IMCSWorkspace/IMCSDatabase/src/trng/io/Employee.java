package trng.io;

import java.io.Serializable;

class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5321850779539410189L;
	String streetNo;
	String streetName;

	public Address(String streetNo, String streetName) {
		super();
		this.streetNo = streetNo;
		this.streetName = streetName;
	}

	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", streetName=" + streetName + "]";
	}

}

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 105L;

	String eName;
	String empID;
	String addInfo;
	float basicSalary;
	Address address;
	static String COMPANY_NAME;
	transient String ssnNo;

//	static {
//		COMPANY_NAME = "ABC Company";
//	}

	// Parametrized constructor

	Employee(String name, String Id, float salary, String ssnNo, Address address) {
		eName = name;
		empID = Id;
		basicSalary = salary;
		this.ssnNo = ssnNo;
		this.address = address;
	}

	public Employee(String eName, String empID, float basicSalary) {
		super();
		this.eName = eName;
		this.empID = empID;
		this.basicSalary = basicSalary;
	}

	Employee() {
	}

	// display method
	void display() {
		System.out.println("Employee name is" + eName);
		System.out.println("employee id is" + empID);
		System.out.println("employee basicsalary is " + basicSalary);
		System.out.println("employee ssnNo is " + ssnNo);
		System.out.println("employee address is " + address);
		System.out.println("Compnay name is: " + COMPANY_NAME);
	}

	public String geteName() {
		return eName;
	}

	public String getEmpID() {
		return empID;
	}

	public float getBasicSalary() {
		return basicSalary;
	}
	
	public void setCompanyName() {
		COMPANY_NAME = "ABC Company";
	}
}