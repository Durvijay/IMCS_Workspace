package trng.excptnHndlng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryWithResourceDemo {

	public static void main(String[] args) {
		TryWithResourceDemo demo = new TryWithResourceDemo();
		Integer number = demo.readNumber();
		
		if (number != null) {
			System.out.println("Give is even number? : " + (number % 2 == 0  ? true : false));
		}
	}
	
	Integer readNumber() {
//		log.info("readNumber is executing", fie);
		Integer number = null;
		
		
		
		System.out.println("Enter a number ");
		
		try (Scanner scanner = new Scanner(System.in); 
			FileInputStream fis = new FileInputStream("abx.txt")){
			number = scanner.nextInt();
			fis.read();
			//other code
		} catch (InputMismatchException | FileNotFoundException fie) { 
			fie.printStackTrace();
			//log.errror("Error occurred while reading file", fie);
			System.out.println("Given input is incorrect, please try with a valid number");
		} catch (IOException io) {
			
		}
		finally {
//			scanner.close();
		}
		
		return number;
	}
}