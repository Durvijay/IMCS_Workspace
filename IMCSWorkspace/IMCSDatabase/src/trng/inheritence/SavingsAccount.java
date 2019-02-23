package trng.inheritence;

public class SavingsAccount extends Account {

	private double interestRate;
	
	//You can declare a field in the subclass with the same name as the one in the superclass, thus�hiding�it (not recommended).
	private String accountName;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(double interestRate, double balance, String accountId) {
		super(balance, accountId);
		this.interestRate = interestRate;
		this.accountName = "Savings Account";
	}

	public SavingsAccount(double interestRate, String accountId) {
		this(interestRate);
		this.setAccountId(accountId);
	}

	public SavingsAccount(double interestRate) {
		if (interestRate > 3) {
			interestRate = 2.5;
		}
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	// Overloaded in the same class
	public double interestCalculation(int time) {
		return (getBalance() * time * interestRate) / 100;
	}

	// Overloaded in the same class
	public double interestCalculation(int time, boolean special) {
		if (special) {
			return (getBalance() * time * (interestRate + 0.5f)) / 100;
		} else {
			return (getBalance() * time * interestRate) / 100;
		}
	}

	/**
	 * 1. Overloading the deposit between super and subclasses
	 * 2. User super keyword to access to super class members. If you don't use super then the one present in the same class will be invoked. 
	 */
	public void deposit(double amt, boolean special) {
		if (special) {
			setBalance(getBalance() + amt + 100);
		} else {
			super.deposit(amt);
		}

	}


	/**
	 * 1. You can write a new�static�method in the subclass that has the same
	 * signature as the one in the superclass, thus�hiding the super method. 2.
	 * You can't override static methods.
	 */
	public static float getInterestRate() {
		System.out.println("calling SavingsAccount::getInterestRate method");
		return INTEREST_RATE + 0.5f;
	}

	/**
	 * 1. You can override static methods with in same class or from super
	 * class.
	 */
	public static float getInterestRate(int x, String y) {
		System.out.println("calling Account::getInterestRate(x) method, second parm is " + y);
		return INTEREST_RATE + x;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", accountName=" + accountName + ", balance=" + balance
				+ ", getAccountName()=" + super.getAccountName() + ", getBalance()=" + getBalance() + ", getAccountId()="
				+ getAccountId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
