package com.imcs.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.imcs.beans.Address;
import com.imcs.exception.EmployeeException;

public class AddressFileReader extends Thread{
	private List<Address> empAddress = new ArrayList<>();
	private String fileName;
	private Reader fileReader;

	public AddressFileReader(File file) throws FileNotFoundException {
		this.fileReader = new FileReader(file);
		this.fileName = file.getName();
	}

	@Override
	public void run() {
		try {
			processFile();
		} catch (EmployeeException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Address> processFile() throws EmployeeException, IOException {

		try (BufferedReader br = new BufferedReader(fileReader)) {

			String line = null;
			while (true) {
				line = br.readLine();
				if (line == null || line.equals("")) {
					break;
				}
				processEmpAddDetails(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new EmployeeException("Something Went Wrong While Reading File");
		} finally {
			if (this.fileReader != null)
				this.fileReader.close();
		}
		return empAddress;
	}

	private void processEmpAddDetails(String line) {
		try {
			Address address = parseLine(line);
			empAddress.add(address);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private Address parseLine(String line) throws ParseException {
		String[] tokens = line.split(",");
		return new Address(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
	}

	public List<Address> getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(List<Address> empAddress) {
		this.empAddress = empAddress;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
