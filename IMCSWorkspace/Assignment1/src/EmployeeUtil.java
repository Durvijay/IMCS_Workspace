
public class EmployeeUtil {

	public static void getHigherSalaryEmployee(Employee[] emp, double amount) {
		if (emp == null)
			return;
		for (Employee employee : emp) {
			if (employee.getSalary() > amount) {
				System.out.println(employee.toString());
			}
		}
	}

	public static double getAverageSalary(Employee[] emp) {
		if (emp == null)
			return 0.0;
		double average = 0;
		for (Employee employee : emp) {
			average += employee.getSalary();
		}
		return average / emp.length;
	}

	public static Employee getMaxSalaryEmployee(Employee[] emp) {
		if (emp == null || emp.length < 1)
			return null;
		Employee maxSalEmp = emp[0];
		for (int i = 1; i < emp.length; i++) {
			if (maxSalEmp.getSalary() < emp[i].getSalary()) {
				maxSalEmp = emp[i];
			}
		}
		return maxSalEmp;
	}

	public static Employee updateLowestSalaryEmployee(Employee[] emp) {
		if (emp == null || emp.length < 1)
			return null;
		Employee lowestSalEmp = emp[0];
		for (int i = 1; i < emp.length; i++) {
			if (lowestSalEmp.getSalary() > emp[i].getSalary()) {
				lowestSalEmp = emp[i];
			}
		}
		lowestSalEmp.setSalary(lowestSalEmp.getSalary() * 1.1);
		return lowestSalEmp;
	}

	public static Employee getEmployeeInfo(Employee[] emp, String name) {
		if (emp == null || emp.length < 1)
			return null;
		Employee empInfo = null;
		for (Employee employee : emp) {
			if (employee.getName().equals(name))
				return employee;
		}
		return empInfo;
	}

}
