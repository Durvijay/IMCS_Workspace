package trng.polymorphism;

/**Super class */

import java.util.Scanner;

interface IBank {
	public static final int INT_RATE = 2;

	public void deposit(int amt);

	public void widthdraw(int amt);

	public double calculateInterest(int t, int r);
	
	public void display();
}

/** Sub Class inheriting the IBank interface */
final class ICICIBanking implements IBank {
	int amt;
	String location;

	ICICIBanking(int p, String location) {
		this.amt = p;
		this.location = location;
	}

	ICICIBanking(String loc) {
		location = loc;
	}

	ICICIBanking() {

	}

	public void deposit(int amt) {
		this.amt = this.amt + amt;
	}

	public void widthdraw(int amt) {
		this.amt = this.amt - amt;
	}

	public double calculateInterest(int t) {
		return (amt * t * INT_RATE) / 100;
	}

	public double calculateInterest(int t, int r) {
		int rate = r;

		if (t > 18) {
			rate = rate + 1;
		}

		return (amt * t * rate) / 100;
	}

	@Override
	public void display() {
		System.out.println(" Amount is: " + amt);
	}
}

/** Sub Class inheriting the Bank interface */
final class AxisBank implements IBank {
	int amt;
	String location;

	AxisBank(int p, String location) {
		this.amt = p;
		this.location = location;
	}

	AxisBank() {

	}

	public void deposit(int amt) {
		this.amt = this.amt + amt;
	}

	public void widthdraw(int amt) {
		this.amt = this.amt - amt;
	}

	public double calculateInterest(int t, int r) {
		return (amt * t * r) / 100;
	}
	
	@Override
	public void display() {
		System.out.println(" Amount is: " + amt);
	}
}

public class InterfaceTest {
	public static void main(String args[]) {
		System.out.println("Calculate Interest for the bank, Chosee the bank \n");
		Scanner scanner = new Scanner(System.in);
		IBank bank = null;
		
		do {
			System.out.println("ICICI Bank = 1");
			System.out.println("AxisBank = 2");
			System.out.println("Enter the choice:");
			
			int opt = scanner.nextInt();
			System.out.println("Enter the Amount:");
			int amount = scanner.nextInt();
	
			System.out.println("Enter the time:");
			int time = scanner.nextInt();
	
			System.out.println("Enter the rate:");
			int rate = scanner.nextInt();
	
			switch (opt) {
			case 1:
				bank = new ICICIBanking(amount, "Nellore");
				break;
			case 2:
				bank = new AxisBank(amount, "Nellore");
				break;
			default:
				System.out.println("Not a valid bank option");
			}

			if (bank != null) {
				System.out.println("Interest for the choosen bank is: " + bank.calculateInterest(time, rate));
/*				bank.deposit(2000);
				bank.display();
				bank.widthdraw(100);
				bank.display();
*/			
				if (bank instanceof ICICIBanking) {
					System.out.println(" ICIC Specia rate: " + ((ICICIBanking) bank).calculateInterest(24));
				}
			}
			
			System.out.println("Do you want try again [Yes/No]");
		} while (true);
		/*
		 * oc.widthdraw(100); System.out.println(
		 * "Total amount after widthdraw: " + oc.amt);
		 * 
		 * 
		 * oc.deposit(1200); System.out.println("Total amount after deposit: " +
		 * oc.amt);
		 */

		/*
		 * Bank b;
		 * 
		 * b = new Bank(2000); System.out.println("Bank Interest cal: " +
		 * b.calculateInterest(19, 2));
		 * 
		 * System.out.println(b instanceof ICICIBank);
		 * 
		 * b = new ICICIBank(2000, "India"); System.out.println(
		 * "ICICI Bank Interest cal: " + b.calculateInterest(19, 2));
		 * 
		 * 
		 * System.out.println(b instanceof Bank); System.out.println(b
		 * instanceof ICICIBank); System.out.println(b instanceof Object);
		 * System.out.println(oc instanceof Bank); System.out.println(oc
		 * instanceof ICICIBank);
		 */
	}
}