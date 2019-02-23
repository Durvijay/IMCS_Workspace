package com.imcs.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imcs.beans.Address;
import com.imcs.beans.Employee;
import com.imcs.service.dao.EmployeeDao;
import com.imcs.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	int count = 1;
	Connection connection = null;
	PreparedStatement prepStatement = null;

	@Override
	public void insertEmployeeRecord(List<Employee> validEmp) throws SQLException {

		try {
			connection = DBUtil.setDBConnection();
			prepStatement = connection.prepareStatement(
					"INSERT INTO employee (EmployeeName,DepartmentId,Salary,Location,DateOfJoin) VALUES (?,?,?,?,?)");

			for (Employee employee : validEmp) {

				if (employee != null) {
					// Set the variables
					prepStatement.setString(1, employee.getName());
					prepStatement.setInt(2, employee.getDepartmentId());
					prepStatement.setDouble(3, employee.getSalary());
					prepStatement.setString(4, employee.getLocation());
					prepStatement.setDate(5, new Date(employee.getDateOfJoin().getTime()));

					// Add it to the batch
					prepStatement.addBatch();

				}
			}
			prepStatement.executeBatch();
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepStatement != null) {
				prepStatement.close();
			}
		}

	}

	@Override
	public List<Employee> getEmpListFilter(double lowerSalaryRange, double higherSalaryRange, String deptName) {
		List<Employee> listOfEmp = new ArrayList<>();
		try {

			connection = DBUtil.setDBConnection();
			prepStatement = connection.prepareStatement(
					"select * from employee e,department d where e.DepartmentId=d.DepartmentId and e.Salary>? and e.Salary<? and d.DepartmentName=?");
			prepStatement.setDouble(1, lowerSalaryRange);
			prepStatement.setDouble(2, higherSalaryRange);
			prepStatement.setString(3, deptName);
			ResultSet resultSet = prepStatement.executeQuery();
			while (resultSet.next()) {
				listOfEmp.add(new Employee(resultSet.getString("Location"), resultSet.getString("EmployeeName"),
						resultSet.getDouble("Salary"), resultSet.getDate("DateOfJoin"),
						resultSet.getInt("DepartmentId")));
			}
			return listOfEmp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfEmp;
	}

	@Override
	public Map<String, Double> getAvgSalaryByDepartment() throws SQLException {
		Map<String, Double> mapAvgSalDept = new HashMap<>();
		connection = DBUtil.setDBConnection();
		prepStatement = connection.prepareStatement(
				"select d.DepartmentName,e.Salary from employee e,department d where e.DepartmentId=d.DepartmentId group by d.DepartmentName");
		ResultSet resultSet = prepStatement.executeQuery();
		while (resultSet.next()) {
			mapAvgSalDept.put(resultSet.getString("DepartmentName"), resultSet.getDouble("Salary"));
		}

		return mapAvgSalDept;
	}

	@Override
	public List<Employee> getEmployeeByDate(java.util.Date doj) throws SQLException {
		List<Employee> listOfEmp = new ArrayList<>();
		connection = DBUtil.setDBConnection();
		prepStatement = connection.prepareStatement("select * from employee where DateOfJoin>?");
		prepStatement.setDate(1, new Date(doj.getTime()));
		ResultSet resultSet = prepStatement.executeQuery();
		while (resultSet.next()) {
			listOfEmp.add(new Employee(resultSet.getString("Location"), resultSet.getString("EmployeeName"),
					resultSet.getDouble("Salary"), resultSet.getDate("DateOfJoin"), resultSet.getInt("DepartmentId")));
		}
		return listOfEmp;
	}

	@Override
	public void insertAddressRecord(List<Address> empAddress) throws SQLException {

		connection = DBUtil.setDBConnection();
		prepStatement = connection.prepareStatement(
				"INSERT IGNORE INTO EmpAddress (empId,street,city,zipcode,state,country) VALUES (?,?,?,?,?,?)");

		for (Address empAdd : empAddress) {
			if (empAdd != null) {
				try {
					// Set the variables
					prepStatement.setInt(1, empAdd.getEmpId());
					prepStatement.setString(2, empAdd.getStreet());
					prepStatement.setString(3, empAdd.getCity());
					prepStatement.setString(4, empAdd.getZipcode());
					prepStatement.setString(5, empAdd.getState());
					prepStatement.setString(6, empAdd.getCountry());

					prepStatement.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		if (prepStatement != null) {
			prepStatement.close();
		}

	}
}
