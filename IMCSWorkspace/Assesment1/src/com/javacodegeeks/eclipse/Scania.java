package com.javacodegeeks.eclipse;

public class Scania extends Truck{

	public Scania() {
		super();
	}

	@Override
	public void drive() {
		System.out.println("I am driving Scania");
	}

	@Override
	public int streer(int str) {
		System.out.println("Steer value of Scania is: "+str);
		return str;
	}

	@Override
	public void stop() {
		System.out.println("I am stoping the Scania");
	}
	
}
