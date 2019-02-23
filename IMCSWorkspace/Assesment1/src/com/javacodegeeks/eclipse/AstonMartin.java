package com.javacodegeeks.eclipse;

public class AstonMartin extends Car {
	private String label;

	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public AstonMartin() {
		super();
	}

	public void bar() {
		System.out.println("Inside bar");
	}
}
