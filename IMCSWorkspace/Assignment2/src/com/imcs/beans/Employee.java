package com.imcs.beans;

import java.util.Date;

import com.imcs.util.EmployeeUtil;

public class Employee {
	private int id;
	private String name;
	private String location;
	private Date dateOfJoin;
	private double salary;
	private int departmentId;

	
	public Employee() {
		super();
	}

	public Employee(String location, String name, double salary, Date dateOfJoin, int departmentId) {
		super();
		this.name = name;
		this.location = location;
		this.departmentId = departmentId;
		this.dateOfJoin = dateOfJoin;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfJoin == null) ? 0 : dateOfJoin.hashCode());
		result = prime * result + departmentId;
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dateOfJoin == null) {
			if (other.dateOfJoin != null)
				return false;
		} else if (!dateOfJoin.equals(other.dateOfJoin))
			return false;
		if (departmentId != other.departmentId)
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Employee name=" + name + ", location=" + location + ", dateOfJoin="
				+ EmployeeUtil.sdf.format(dateOfJoin) + ", salary=" + salary + ", departmentId=" + departmentId;
	}

}
