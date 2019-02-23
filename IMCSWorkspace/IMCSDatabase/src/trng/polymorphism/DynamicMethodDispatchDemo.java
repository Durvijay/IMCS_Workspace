package trng.polymorphism;

import java.util.Scanner;

public class DynamicMethodDispatchDemo {

	public static void main(String args[]) {
		usage1();
		usage2();
	}

	private static void usage1() {
		Bank b;
		b = new Bank(2000); //Here b is pointing to Bank object
		System.out.println("Bank Interest cal: " + b.calculateInterest(19, 2)); //calculateInterest method is called from Bank

		b = new ICICIBank(2000, "India");
		System.out.println("ICICI Bank Interest cal: " + b.calculateInterest(19, 2)); //calculateInterest method is called from ICICIBank
	}

	/**
	 * Through the input you can reference to the corresponding object and call the method.
	 */
	private static void usage2() {
		Bank b;
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Which implementation you want? [Bank/ICICI] ?");
		String opt = scanner.next();
		int t = 19;
		int r = 2;
		double result = 0;
		switch(opt) {
			case "Bank":
				b = new Bank();
				result = b.calculateInterest(t, r);
				break;
			case "ICICI":
				b = new ICICIBank(2000, "Chennai");
				result = b.calculateInterest(t, r);
				break;
			default:
				System.out.println("Invalid option");
				break;
		}
		
		System.out.println("Interest is: " + result);
	}
}
