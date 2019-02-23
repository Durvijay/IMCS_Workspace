

public class EmployeeApp {
	public static void main(String[] args) {

		int N = 10;
		Employee[] arrEmp = new Employee[N];
		for (int i = 0; i < arrEmp.length; i++) {
			arrEmp[i] = new Employee("562546416" + i, "vijay" + i, 4995 + i);
		}

		EmployeeUtil.getHigherSalaryEmployee(arrEmp, 5000);
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Average Salary of Employees are :" + EmployeeUtil.getAverageSalary(arrEmp));
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Highest paid Employee :" + EmployeeUtil.getMaxSalaryEmployee(arrEmp).toString());
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Lowest paid Employee :" + EmployeeUtil.updateLowestSalaryEmployee(arrEmp).toString());
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Record for Employee vijay5 :" + EmployeeUtil.getEmployeeInfo(arrEmp, "vijay5"));
		System.out.println("-----------------------------------------------------------------------");

	}
}
