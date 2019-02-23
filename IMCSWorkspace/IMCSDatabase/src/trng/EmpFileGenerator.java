package trng;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class EmpFileGenerator {
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter  writer = new PrintWriter(new File("c:\\temp\\inputfile.csv"));
		for(int i=0; i<10000; i++) {
			writer.write(getDept() + "," + getName(i) + "," + getSalary() + "," + getDoJ() + "\n");
		}
		
		writer.flush();
		writer.close();
	}
	
	private static String getDoJ() {
		String[] year = {"2001", "2002", "2003", "2004", "2018", "2015"};
		String[] month = {"01", "05", "14", "12", "07", "08"};
		String[] day = {"01", "10", "05", "08", "30"};
		return year[getRandomNumberInRange()] + "-" + month[getRandomNumberInRange()] + "-" + day[getRandomNumberInRange()];
	}
	
	private static String getName(int index) {
		String[] name = {"David", "Pingel", "Nancy", "Stuart", "Wilken"};
		return name[getRandomNumberInRange()] + index;
	}

	private static String getSalary() {
		String[] salary = {"7000", "6000", "8000", "10000", "11000"};
		return salary[getRandomNumberInRange()];
	}

	private static String getDept() {
		String[] deptString = {"10,Sales,Dallas", "20,Purchase,Chicago", "30,HR,NewYork", "40,Admin,Washingon", "50,Clerk,Dallas"};
		return deptString[getRandomNumberInRange()];
	}
	

	private static int getRandomNumberInRange() {
		Random r = new Random();
		return r.nextInt((4 - 0) + 1) + 0;
	}
}
