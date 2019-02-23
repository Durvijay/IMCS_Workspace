package com.imcs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.imcs.beans.Address;
import com.imcs.beans.Employee;

public class EmployeeUtil {
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static Date dateparse(String date) throws ParseException {
		String[] datesplit = date.split("-");
		Date date1 = sdf.parse(date);
		if (Integer.parseInt(datesplit[1]) > 12 || Integer.parseInt(datesplit[2]) > 31) {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.add(Calendar.YEAR, 1);
			date1 = c.getTime();
		}
		return date1;
	}

	public static String validateEmpRecord(Employee emp) {
		StringBuilder reason = new StringBuilder();
		if (new Date().compareTo(emp.getDateOfJoin()) < 0) {
			reason.append("Date cannnot be grater than todays Date. ");
		}
		if (emp.getSalary() <= 7000 || emp.getSalary() >= 10000) {
			reason.append("Salary is out of Range. ");
		}
		return reason.toString();
	}
	
	public static void displayMenuOptions() {
		EmployeeUtil.message("Select the operation you would like to perform :");
		EmployeeUtil.message("1. Display the summary of the loaded file");
		EmployeeUtil.message("2. Display the employees who's salary between given range and given department");
		EmployeeUtil.message("3. Display department wise average salary");
		EmployeeUtil.message("4. Display employees who joined after given date.");
		EmployeeUtil.message("5. Exit the Program.");
		System.out.println();
	}

	public static void message(String message) {
		System.out.println(message);
	}

	public static void errorMessage(String message) {
		System.err.println(message);
	}
}
