package com.imcs.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.imcs.beans.Department;
import com.imcs.beans.Employee;
import com.imcs.exception.EmployeeException;
import com.imcs.util.EmployeeUtil;

public class EmployeeFileReader extends Thread{
	private Map<Employee, String> invalidEmp = new HashMap<>();
	private Set<Department> departmentList = new HashSet<>();
	private List<Employee> validEmployees = new ArrayList<>();
	private String fileName;
	private Reader fileReader;

	public EmployeeFileReader(File file) throws FileNotFoundException {
		this.fileReader = new FileReader(file);
		this.fileName = file.getName();
	}

	
	@Override
	public void run() {
		try {
			processFile();
		} catch (EmployeeException | IOException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> processFile() throws EmployeeException, IOException {

		try (BufferedReader br = new BufferedReader(fileReader)) {

			String line = null;
			while (true) {
				line = br.readLine();
				if (line == null || line.equals("")) {
					break;
				}
				processEmployeeDetails(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new EmployeeException("Something Went Wrong While Reading File");
		} finally {
			if (this.fileReader != null)
				this.fileReader.close();
		}
		return validEmployees;
	}

	private void processEmployeeDetails(String line) {
		try {
			Employee emp = parseLine(line);
			// check Error Message Length of Valid Employee
			String errorMessage = EmployeeUtil.validateEmpRecord(emp);
			if (errorMessage.length() < 1) {
				validEmployees.add(emp);
			} else {
				invalidEmp.put(emp, errorMessage);
			}
		} catch (ParseException e) {
			invalidEmp.put(new Employee(), line + " Unable to Parse. Check the Data.");
		}
	}

	private Employee parseLine(String line) throws ParseException {
		String[] tokens = line.split(",");
		Department department = new Department(Integer.parseInt(tokens[0]), tokens[1]);
		departmentList.add(department);
		return new Employee(tokens[2], tokens[3], Double.parseDouble(tokens[4]), EmployeeUtil.dateparse(tokens[5]),
				department.getDepartmentId());
	}

	public Map<Employee, String> getInvalidEmp() {
		return invalidEmp;
	}

	public void setInvalidEmp(Map<Employee, String> invalidEmp) {
		this.invalidEmp = invalidEmp;
	}

	public Set<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(Set<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Employee> getValidEmployees() {
		return validEmployees;
	}

	public void setValidEmployees(List<Employee> validEmployees) {
		this.validEmployees = validEmployees;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
