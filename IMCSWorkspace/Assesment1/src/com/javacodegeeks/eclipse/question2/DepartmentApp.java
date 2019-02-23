package com.javacodegeeks.eclipse.question2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DepartmentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Department> list = new ArrayList<>();
		list.add(new Department(4, "Support", "Cali"));
		list.add(new Department(1, "Marketing", "Cali"));
		list.add(new Department(3, "Humanresurce", "Cali"));
		list.add(new Department(2, "Purchase", "Cali"));

		System.out.println("Select option to Sort department by:");
		System.out.println("1. Sort by Department Id:");
		System.out.println("2. Sort by Department Name:");
		int option = sc.nextInt();
		if (option == 1) {
			Collections.sort(list, new SortByDepartmentNo());
			displaytheList(list);
		} else if (option == 2) {
			Collections.sort(list, new SortByDepartmentName());
			displaytheList(list);
		}

	}

	private static void displaytheList(List<Department> list) {
		for (Department department : list) {
			System.out.println(department);
		}

	}

}
