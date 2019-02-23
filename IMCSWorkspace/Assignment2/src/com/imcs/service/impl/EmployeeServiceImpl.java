package com.imcs.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imcs.beans.Employee;
import com.imcs.beans.Summary;
import com.imcs.exception.EmployeeException;
import com.imcs.fileReader.AddressFileReader;
import com.imcs.fileReader.EmployeeFileReader;
import com.imcs.fileWriter.EmployeeErrorReport;
import com.imcs.service.dao.DepartmentDao;
import com.imcs.service.dao.EmployeeDao;
import com.imcs.service.dao.EmployeeService;
import com.imcs.service.dao.SummaryDao;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private DepartmentDao deptDao = new DepartmentDaoImpl();
	private SummaryDao summaryDao = new SummaryDaoImpl();

	@Override
	public EmployeeFileReader createEmployees(File file) throws EmployeeException, FileNotFoundException {
		EmployeeFileReader eFileReader = new EmployeeFileReader(file);
		AddressFileReader addressFileReader=new AddressFileReader(file);
		try {
			eFileReader.start();
			addressFileReader.start();
			eFileReader.join();
			deptDao.insertDepatmentRecords(eFileReader.getDepartmentList());
			employeeDao.insertEmployeeRecord(eFileReader.getValidEmployees());
			summaryDao.insertSummaryRecord(createSummary(eFileReader));
			addressFileReader.join();
			employeeDao.insertAddressRecord(addressFileReader.getEmpAddress());
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmployeeException("Something Went Wrong while inserting Records");
		}
		return eFileReader;
	}

	@Override
	public Summary createSummary(EmployeeFileReader eFileReader) throws SQLException {
		return new Summary(eFileReader.getValidEmployees().size(), eFileReader.getInvalidEmp().size(),
				eFileReader.getFileName(), new Date(),
				eFileReader.getValidEmployees().size() + eFileReader.getInvalidEmp().size(),
				eFileReader.getDepartmentList().size());

	}

	@Override
	public String generateInvalidEmpRecords(EmployeeFileReader eFileReader, String directory) throws IOException {
		EmployeeErrorReport errorReport = new EmployeeErrorReport();
		if (eFileReader != null && eFileReader.getInvalidEmp() != null && eFileReader.getInvalidEmp().size() > 0) {
			return errorReport.generateInvalidEmpRecords(directory, eFileReader.getInvalidEmp());
		} else {
			return "Invalid Records Not Found.";
		}
	}

	@Override
	public List<Employee> getEmpListFilter(double lowerSalaryRange, double higherSalaryRange, String deptName) {
		return employeeDao.getEmpListFilter(lowerSalaryRange, higherSalaryRange, deptName);
	}

	@Override
	public Map<String, Double> getAvgSalaryByDepartment() {
		deptDao = new DepartmentDaoImpl();
		employeeDao = new EmployeeDaoImpl();
		try {
			return employeeDao.getAvgSalaryByDepartment();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new HashMap<>();
	}

	@Override
	public List<Employee> getEmployeeByDate(Date doj) {
		employeeDao = new EmployeeDaoImpl();
		try {
			return employeeDao.getEmployeeByDate(doj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Summary> getEmployeeInsertSummary() {
		summaryDao = new SummaryDaoImpl();
		try {
			return summaryDao.getEmployeeInsertSummary();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
