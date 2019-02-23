package trng.polymorphism;

import java.util.Scanner;

/**Super class */

class Bank {
	int amt;
	public static final String BANK_NAME = "ABC Bank";
	
	Bank(int pri) {
		amt = pri;
	}
	
	Bank () {
	
	}
	
	final void deposit(int amt) {
		this.amt = this.amt + amt;
	}

	double  calculateInterest(int t, int r) {
		return (amt * t * r) / 100;
	}	
	
	void displayInfo() {
		System.out.println("Total Amount present: " + amt);
		System.out.println(BANK_NAME);
	}
	
}

/** Sub Class inheriting the Bank class */
final class ICICIBank extends Bank {
	String location;
	
	ICICIBank(int p, String location) {
		super(p);
		this.location = location;
	}
	
	ICICIBank(String loc) {
		location = loc;
	}
	
	ICICIBank() {
	
	}
	
	double  calculateInterest(int t) {	
		int r = 2;
		return (amt * t * r) / 100;
	}
	
	@Override
	double  calculateInterest(int t, int r) {
		int rate = r;
		
		if (t > 18) {
			rate = rate + 1;
		}
		
		return (amt * t * rate) / 100;
	}	
}

public class OverloadingAndOverriding {
	public static void main(String args[]) {
		ICICIBank oc = new ICICIBank(2000, "India");
		System.out.println("Total amount : " + oc.amt); //The object OC can access properties from super class.
		System.out.println("Bank Location: " + oc.location); 
		System.out.println("Interest: " + oc.calculateInterest(12));	//Overloaded method with one parameter is called.	
		System.out.println("Interest: " + oc.calculateInterest(19, 2));	//Overloaded method with two parameters is called.
		
		
		Bank b;
		
		b = new Bank(2000); 
		System.out.println("Bank Interest cal: " + b.calculateInterest(19, 2));
		
		System.out.println(b instanceof ICICIBank);
		
		b = new ICICIBank(2000, "India"); //super class variable refers to subclass object.
		System.out.println("ICICI Bank Interest cal: " + b.calculateInterest(19, 2));
		
		
		System.out.println(b instanceof Bank);
		System.out.println(b instanceof ICICIBank);
		System.out.println(b instanceof Object);
		System.out.println(oc instanceof Bank);
		System.out.println(oc instanceof ICICIBank);
	}

}