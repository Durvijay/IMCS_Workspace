package com.javacodegeeks.eclipse;

import java.util.Scanner;

public class VechileApp {

	public static void main(String[] args) {
		Vehicle vehicle = null;
		Scanner sc = new Scanner(System.in);
		try {
			vehicle = displayVechileOptions(sc, vehicle);
			if (vehicle == null) {
				System.out.println("Invalid selection");
			} else {
				vehicle.drive();
				vehicle.streer(3);
				vehicle.stop();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Vehicle displayVechileOptions(Scanner sc, Vehicle vehicle) {
		System.out.println("Please Select the vechile from the given type:");
		System.out.println("1. Aston Martin");
		System.out.println("2. Ferrari");
		System.out.println("3. Scania");
		System.out.println("4. Man");
		int vehicleOption = sc.nextInt();
		if (vehicleOption == 1) {
			return new AstonMartin();
		} else if (vehicleOption == 2) {
			return new Ferrari();
		} else if (vehicleOption == 3) {
			return new Scania();
		} else if (vehicleOption == 4) {
			return new Man();
		} else {
			return null;
		}

	}

}
