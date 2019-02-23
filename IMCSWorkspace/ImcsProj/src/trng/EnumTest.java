package trng;

import java.io.IOException;
import java.util.Scanner;

enum Day {
    SUNDAY,

    MONDAY,

    TUESDAY,

    WEDNESDAY,

    THURSDAY,

    FRIDAY,

    SATURDAY;
}

enum EmployeeColumn {
	EMPNO (1, "emp_no"), EMPNAME (2), EMPSAL(3), DEPTNO(4), UNKNOW(-1);
	
	int empColIndex;
	String columnName;
	
	
	EmployeeColumn(int columnIndex) {
		this.empColIndex = columnIndex;
	}
	EmployeeColumn(int columnIndex, String columnName) {
		this.empColIndex = columnIndex;
		this.columnName = columnName;
	}
	
	static EmployeeColumn getEmpColumn(int givenIndex) {
		EmployeeColumn EmpColumn;
		
		for(EmployeeColumn empCol : EmployeeColumn.values()) {
			if (empCol.empColIndex == givenIndex) {
				return empCol;
			}
		}
		
		return UNKNOW;
	}
	public int getEmpColIndex() {
		return empColIndex;
	}
	public String getColumnName() {
		return columnName;
	}
}


public class EnumTest {
	public static void main(String... args) throws IOException {
		EnumTest enumTest = new EnumTest();
		EmployeeColumn selectedEmpColumn = getSelectedEmpColumn();
		process(selectedEmpColumn);
	}

	private static EmployeeColumn getSelectedEmpColumn() throws IOException {
		EmployeeColumn selectedEmpColumn;
		
		for(EmployeeColumn empCol : EmployeeColumn.values()) {
			System.out.println(empCol.empColIndex + " : " + empCol.name());
		}
		
		System.out.println("Select the column: ");
		int selectedIndex = new Scanner(System.in).nextInt();
		
		selectedEmpColumn = EmployeeColumn.getEmpColumn(selectedIndex);
		return selectedEmpColumn;
	}
	
	private static void process(EmployeeColumn selectedEmpColumn) {
		switch (selectedEmpColumn) {
		case EMPNO:
			System.out.println("this is primary key " + selectedEmpColumn.empColIndex);
			break;
		case EMPNAME:
			System.out.println("this is " + EmployeeColumn.EMPNAME);
			break;
		case EMPSAL :
			System.out.println("this is " + EmployeeColumn.EMPNAME);
			break;
	}
	}
}
