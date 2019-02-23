import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.imcs.beans.Employee;
import com.imcs.beans.Summary;
import com.imcs.exception.EmployeeException;
import com.imcs.fileReader.EmployeeFileReader;
import com.imcs.service.dao.EmployeeService;
import com.imcs.service.impl.EmployeeServiceImpl;
import com.imcs.util.Constants;
import com.imcs.util.EmployeeUtil;

public class EmployeeApp {

	public static void main(String[] args) {
		EmployeeService empService = new EmployeeServiceImpl();
		File file = new File(Constants.EMP_FILE_PATH);
		Scanner sc = new Scanner(System.in);
		try {

			if (file.exists()) {
				EmployeeFileReader eFileReader = empService.createEmployees(new File(Constants.EMP_FILE_PATH));
				empService.generateInvalidEmpRecords(eFileReader, file.getAbsolutePath());
			} else {
				EmployeeUtil.errorMessage("Please Provide a vaild Employee file entry.");
			}
		} catch (EmployeeException | IOException e) {
			EmployeeUtil.errorMessage(e.getMessage());

		}

		while (true) {
			int option = -1;
			EmployeeUtil.displayMenuOptions();
			try {
				option = sc.nextInt();
			} catch (Exception e) {
				EmployeeUtil.message("Enter only numbers: ");
			}
			switch (option) {
			case 1:
				displayEmpFileSummary(empService);
				break;
			case 2:
				displayEmpBySalAndDept(sc, empService);
				break;
			case 3:
				displayDeptByAvgSalary(empService);
				break;
			case 4:
				displayEmpAfterDate(sc, empService);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				EmployeeUtil.errorMessage("Please select only from the given option");
				break;
			}
		}
	}

	private static void displayEmpFileSummary(EmployeeService empService) {
		List<Summary> summaryList = empService.getEmployeeInsertSummary();
		if (!summaryList.isEmpty()) {
			for (Summary summ : summaryList) {
				EmployeeUtil.message(summ.toString());
			}
		} else {
			EmployeeUtil.errorMessage(Constants.RESULT_NOT_FOUND_MESSAGE);
		}
	}

	private static void displayEmpAfterDate(Scanner sc, EmployeeService empService) {
		EmployeeUtil.message("Enter the date of Join in the following Format (yyyy-mm-dd):");
		try {
			Date date = EmployeeUtil.dateparse(sc.next());
			if (new Date().compareTo(date) < 0) {
				EmployeeUtil.errorMessage("Enterted date cannot be greater than today's date.");
			} else {
				List<Employee> empListByDate = empService.getEmployeeByDate(date);
				if (empListByDate.isEmpty()) {
					EmployeeUtil.errorMessage(Constants.RESULT_NOT_FOUND_MESSAGE);
				} else {
					for (Employee emp : empListByDate) {
						EmployeeUtil.message(emp.toString());
					}
				}
			}
		} catch (ParseException e) {
			EmployeeUtil.errorMessage("Invalid Date. Please try again.");
			e.printStackTrace();
		}

	}

	private static void displayDeptByAvgSalary(EmployeeService empService) {
		Map<String, Double> avgSalary = empService.getAvgSalaryByDepartment();
		if (avgSalary.isEmpty()) {
			EmployeeUtil.errorMessage(Constants.RESULT_NOT_FOUND_MESSAGE);
		} else {
			for (String deptsName : avgSalary.keySet()) {
				EmployeeUtil.message(deptsName + " : " + avgSalary.get(deptsName));
			}

		}
	}

	private static void displayEmpBySalAndDept(Scanner sc, EmployeeService empService) {
		EmployeeUtil.message("Enter the Range of Salary.");
		EmployeeUtil.message("Lower Range : ");
		double lowerSalaryRange = sc.nextDouble();
		EmployeeUtil.message("Higher Range : ");
		double higherSalaryRange = sc.nextDouble();
		EmployeeUtil.message("Enter the Department Name :");
		String deptName = sc.next();
		EmployeeUtil.message("");
		List<Employee> list = empService.getEmpListFilter(lowerSalaryRange, higherSalaryRange, deptName);
		if (list == null || list.isEmpty())
			EmployeeUtil.errorMessage("No Records to Display");
		for (Employee employee : list) {
			EmployeeUtil.message(employee.toString());
		}
	}
}
