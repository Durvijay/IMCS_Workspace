package trng.inheritence;

/**
 * 
 * 1. subclass of Account.
 * 2. Can access all the member of super class Account, except private members.
 */
public class CheckingAccount extends Account {
	
	/**
	 * You can declare new members in the subclass that are not in the superclass.
	 */
	private double overdraftProtection;
	private static final double MINIMUM_BALANCE = 1500.00;
	
	public CheckingAccount() {
		super();
	}

	/**
	 * 1. Use super to invoke super class constructor.
	 * 2. It is subclass responsibility to initialize super class with it's constructor.
	 */
	public CheckingAccount(double overdraftProtection, double balance, String accountId) {
		super(balance, accountId);
		this.overdraftProtection = overdraftProtection;
	}
	
	/**
	 * 
	 * 1. Subclass can have it'w own methods.
	 */
	public double minimumBalance() {
		return MINIMUM_BALANCE;
	}

	/**
	 * You can write a new�instance�method in the subclass that has the same signature as the one 
	 * in the superclass, thus�overriding�it.
	 */
	@Override
	public boolean withdraw(double amt) {
		System.out.println("calling CheckingAccount:withdraw method");
		
		
		if ((getBalance() >= 0) && (getBalance() + overdraftProtection) - amt >= 0) {
			setBalance(getBalance() - amt);
			return true;
		} else {
			return super.withdraw(amt);
		}
	}
	
	public double getOverdraftProtection() {
		return overdraftProtection;
	}

	public void setOverdraftProtection(double overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
	}
}
