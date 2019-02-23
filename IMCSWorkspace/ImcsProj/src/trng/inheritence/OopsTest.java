package trng.inheritence;

import java.util.Scanner;

public class OopsTest {

	public static void main(String[] args) {
//		useCheckingsAccount();
//		useSavingsAccount();
//		useSuperClass();
		dynamicMethodDispatch();
//		useStaticMethodsBetweenSperAndSubClasses();
	}

	/**
	 * 1. You can overload static methods.
	 * 2. You can't override static methods.
	 * 3. You can write a new�static�method in the subclass that has the same signature as the one in the superclass, thus�hiding�it.
	 */
	private static void useStaticMethodsBetweenSperAndSubClasses() {
		System.out.println(Account.getInterestRate());
		System.out.println(SavingsAccount.getInterestRate());
		System.out.println(Account.getInterestRate(3));
		System.out.println(SavingsAccount.getInterestRate(3));
		System.out.println(SavingsAccount.getInterestRate(3, "Hello"));
		
	}

	/**
	 * 1. Create object to subclass and access all the members members of super class along with it's own members.
	 * 2. If member(s) are not present in sub class then it will get it from super class.
	 */
	public static void useCheckingsAccount() {
		CheckingAccount ca = new CheckingAccount(1000, 2000, "C102");
		ca.deposit(500);
		ca.withdraw(900);
		System.out.println("AccountId: " + ca.getAccountId());
		System.out.println("OverdraftProtection : " + ca.getOverdraftProtection());
		System.out.println("Balance : " + ca.getBalance());
		boolean success = ca.withdraw(2000);
		System.out.println("2000 withdraw successful? " + success);
	
	}

	/**
	 * 1. Create object to subclass and access all the members members of super class along with it's own members.
	 * 2. If member(s) are not present in sub class then it will get it from super class.
	 * 3. static polymorphism (Method overloading): Here compile knows that interestCalculation(24) method is calling from SavingsAccount
	 */
	public static void useSavingsAccount() {
		SavingsAccount sa = new SavingsAccount(2, 2000, "S101");
		System.out.println(sa.interestCalculation(24));
		sa.deposit(500);
		sa.withdraw(900);
		System.out.println("AccountId: " + sa.getAccountId());
		System.out.println("Balance : " + sa.getBalance());
		boolean success = sa.withdraw(3000);
		System.out.println("withdraw successful? " + success);

	}
	
	/**
	 * 1. Super class variable can reference sub class object.
	 * 
	 * 2. Using super class variable you can access members from the super class, but at runtime it will access/execute the methods that it is referencing to.
	 * 
	 * 3. Dynamic binding (or) late binding (or) Virtual binding (Method overriding): 
	 * 		Here compiler doesn't know which method reference variable is referencing at compile time, only JVM know that depending on 
	 * 		the object it is referencing at runtime.
	 * 
	 *  Account sa = new SavingsAccount(1000, 2000, "C102");
		sa.withdraw(300);
	 * 
	 */
	public static void useSuperClass() {
		Account acct = new Account(2000, "C102");
		acct.withdraw(900);
		System.out.println("Balance : " + acct.getBalance());
		
		Account ca = new CheckingAccount(1000, 2000, "C102");
		ca.withdraw(900);
//		System.out.println("OverdraftProtection : " + ca.getOverdraftProtection());
		System.out.println("Balance : " + ca.getBalance());

		Account sa = new SavingsAccount(1000, 2000, "C102");
		sa.withdraw(300);
		System.out.println("Balance : " + sa.getBalance());
	}
	
	/**
	 * Dynamic binding: 
	 */
	public static void dynamicMethodDispatch() {
		System.out.println("what account you want ? (1. savings, 2. checking");
		String option = new  Scanner(System.in).next();
		
		Account account = null;
		switch(option) {
		case "1" :
			account = new SavingsAccount(2, 2000, "S101");
			displaySavings((SavingsAccount) account);
			break;
		case "2":
			account = new CheckingAccount(1000, 2000, "C102");
			break;
		default:
			account = new Account();
			break;
		}
		
		display(account);
		display(new SavingsAccount(2, 2000, "S107"));
		display(new CheckingAccount(500, 2000, "C107"));
	}
	
	private static void display(Account account) {
		account.deposit(500);
		account.withdraw(2500);
		System.out.println("AccountId: " + account.getAccountId());
		System.out.println("Balance : " + account.getBalance());
		boolean success = account.withdraw(2000);
		System.out.println("withdraw successful? " + success);
	}
	
	
	private static void displaySavings(SavingsAccount account) {
		System.out.println("special display callled");
	}
}
