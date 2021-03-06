package com.imcs.beans;

public class Address {
	private int empId;
	private String street;
	private String city;
	private String zipcode;
	private String state;
	private String country;
	
	
	public Address(int empId, String street, String city, String zipcode, String state, String country) {
		super();
		this.empId = empId;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
	}
	
	public Address() {
		super();
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
