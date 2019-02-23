package com.imcs.service.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.imcs.beans.Employee;
import com.imcs.beans.Summary;
import com.imcs.exception.EmployeeException;
import com.imcs.fileReader.EmployeeFileReader;

public interface EmployeeService {

	public EmployeeFileReader createEmployees(File file) throws EmployeeException, FileNotFoundException;

	public Summary createSummary(EmployeeFileReader eFileReader) throws SQLException;

	public String generateInvalidEmpRecords(EmployeeFileReader eFileReader, String directory) throws IOException;

	public List<Employee> getEmpListFilter(double lowerSalaryRange, double higherSalaryRange, String deptName);

	public Map<String, Double> getAvgSalaryByDepartment();

	public List<Employee> getEmployeeByDate(Date date);

	public List<Summary> getEmployeeInsertSummary();

	


}
