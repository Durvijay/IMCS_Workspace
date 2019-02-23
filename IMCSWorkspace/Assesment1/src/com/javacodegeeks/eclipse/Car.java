package com.javacodegeeks.eclipse;

public class Car implements Vehicle {
	private int weels;
	private int doors;

	
	public Car() {
		super();
	}

	public int getWeels() {
		return weels;
	}

	public void setWeels(int weels) {
		this.weels = weels;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	@Override
	public void drive() {
		System.out.println("I am driving Car");
	}

	@Override
	public int streer(int str) {
		System.out.println("Steer value is: "+str);
		return str;
	}

	@Override
	public void stop() {
		System.out.println("I am stoping the car");
	}

}
