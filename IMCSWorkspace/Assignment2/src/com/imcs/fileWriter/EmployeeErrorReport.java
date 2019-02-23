package com.imcs.fileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.imcs.beans.Employee;

public class EmployeeErrorReport {
	// Create file with all failure records, where error description should be
	// added to the file
	public String generateInvalidEmpRecords(String directory, Map<Employee, String> invalidEmpMap) throws IOException {
		
		File filedirctory = new File(directory);
		if (!filedirctory.exists()) {
			filedirctory.mkdirs();
		}
		System.out.println("directory :" + directory);
		try(FileWriter fw = new FileWriter(directory + "\\" + "ErrorFile.csv");
				BufferedWriter bw = new BufferedWriter(fw);){
			Iterator<Employee> keySetIterator = invalidEmpMap.keySet().iterator();
			bw.write("Employee Details                  :       Reason \n");
			while (keySetIterator.hasNext()) {
				Employee emp = keySetIterator.next();
				bw.write(emp.toString() + "," + invalidEmpMap.get(emp));
				bw.write("\n");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	return null;
}

}
