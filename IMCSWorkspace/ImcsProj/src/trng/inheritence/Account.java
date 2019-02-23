package trng.inheritence;


/**
 * Super class Account.
 * 
 * 1. By default every class is subclass of Object class.
 */
public class Account {
	/**
	 * 1. You can access the balance outside the package as it is with default access modifer.
	 * 2. YOu can access the protected anywhere in the package and in the subclasses of outer package.  
	 */
	double balance;
	private String accountId;
	protected String accountName;

	static final float INTEREST_RATE = 2;
	
	public Account() {
		super();
		this.accountName = "Account";
	}
	
	public Account(double balance, String accountId) {
		super();
		this.balance = balance;
		this.accountId = accountId;
		this.accountName = "Account";
	}
	
	public void deposit(double amt) {
		this.balance = this.balance + amt;
	}
	
	public boolean withdraw(double amt) {
		System.out.println("called Account::withdraw method");
		if (this.balance - amt > 0) {
			this.balance = this.balance - amt;
			return true;
		} else {
			return false;
		}
	}
	
//	public abstract double interestCalculation(int time);

	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public static float getInterestRate() {
		System.out.println("calling Account::getInterestRate method");
		return INTEREST_RATE;
	}
	
	
	public static float getInterestRate(int x) {
		System.out.println("calling Account::getInterestRate(x) method");
		return INTEREST_RATE + x;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
