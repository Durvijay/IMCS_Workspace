package com.javacodegeeks.eclipse;

public class Truck implements Vehicle {

	
	public Truck() {
		super();
	}

	@Override
	public void drive() {
		System.out.println("I am driving Truck");
	}

	@Override
	public int streer(int str) {
		System.out.println("Steer value of truck is: "+str);
		return str;
	}

	@Override
	public void stop() {
		System.out.println("I am stoping the Truck");
	}

}
