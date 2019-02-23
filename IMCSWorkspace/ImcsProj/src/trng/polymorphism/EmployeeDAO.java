package trng.polymorphism;

import java.util.List;

import trng.inheritence.Employee;

public interface EmployeeDAO 
{
	public boolean add(Employee t);

	public boolean update(int index, Employee t);

	public boolean remove(int empNo);

	public Employee getByIndex(int empNo);

	public List<Employee> getAll();
}