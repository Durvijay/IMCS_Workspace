package com.javacodegeeks.eclipse;

public class Man extends Truck{

	public Man() {
		super();
	}

	@Override
	public void drive() {
		System.out.println("I am driving Man");
	}

	@Override
	public int streer(int str) {
		System.out.println("Steer value of Man is: "+str);
		return str;
	}

	@Override
	public void stop() {
		System.out.println("I am stoping the Man");
	}

	
}
