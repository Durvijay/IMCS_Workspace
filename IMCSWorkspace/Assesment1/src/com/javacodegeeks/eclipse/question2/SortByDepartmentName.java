package com.javacodegeeks.eclipse.question2;

import java.util.Comparator;

public class SortByDepartmentName implements Comparator<Department> {

	@Override
	public int compare(Department o1, Department o2) {
		return o1.getDeptName().compareTo(o2.getDeptName());
	}

}
