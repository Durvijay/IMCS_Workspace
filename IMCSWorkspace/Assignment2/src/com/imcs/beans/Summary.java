package com.imcs.beans;

import java.util.Date;

public class Summary {
	private int noOfValidRecords;
	private int noOfInvalidRecords;
	private String fileName;
	private Date uploadedDate;
	private int totalRecords;
	private int totalDepartments;

	
	public Summary(int noOfValidRecords, int noOfInvalidRecords, String fileName, Date uploadedDate, int totalRecords,
			int totalDepartments) {
		super();
		this.noOfValidRecords = noOfValidRecords;
		this.noOfInvalidRecords = noOfInvalidRecords;
		this.fileName = fileName;
		this.uploadedDate = uploadedDate;
		this.totalRecords = totalRecords;
		this.totalDepartments = totalDepartments;
	}

	public int getNoOfValidRecords() {
		return noOfValidRecords;
	}

	public void setNoOfValidRecords(int noOfValidRecords) {
		this.noOfValidRecords = noOfValidRecords;
	}

	public int getNoOfInvalidRecords() {
		return noOfInvalidRecords;
	}

	public void setNoOfInvalidRecords(int noOfInvalidRecords) {
		this.noOfInvalidRecords = noOfInvalidRecords;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalDepartments() {
		return totalDepartments;
	}

	public void setTotalDepartments(int totalDepartments) {
		this.totalDepartments = totalDepartments;
	}

	@Override
	public String toString() {
		return "Valid Records :" + noOfValidRecords + ", InValid Records :" + noOfInvalidRecords
				+ ", File Name :" + fileName + ", Uploaded Date :" + uploadedDate + ", Total Records :" + totalRecords
				+ ", Total number of Departments :" + totalDepartments;
	}
	
	

}
