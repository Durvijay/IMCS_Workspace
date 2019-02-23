package com.javacodegeeks.eclipse;

public class Ferrari extends Car{
	private String badge;

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}
	public Ferrari() {
		super();
	}

	public void foo() {
		System.out.println("Inside foo method");
	}
}
