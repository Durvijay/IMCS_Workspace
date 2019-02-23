package com.imcs.service.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.imcs.beans.Address;
import com.imcs.beans.Employee;

public interface EmployeeDao {

	public void insertEmployeeRecord(List<Employee> validEmp) throws SQLException;

	public List<Employee> getEmpListFilter(double lowerSalaryRange, double higherSalaryRange, String deptName);

	public Map<String, Double> getAvgSalaryByDepartment() throws SQLException;

	public List<Employee> getEmployeeByDate(Date doj) throws SQLException;

	public void insertAddressRecord(List<Address> empAddress) throws SQLException;

}
