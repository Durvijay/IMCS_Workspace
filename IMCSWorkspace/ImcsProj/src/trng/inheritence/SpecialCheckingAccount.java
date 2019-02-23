package trng.inheritence;

/**
 * Final method can't be overriden.
 */
public class SpecialCheckingAccount extends CheckingAccount {
	@Override
	public boolean withdraw(double amt) {
		System.out.println("inside SpecialCheckingAccount:withdraw method");
		return super.withdraw(amt);
	}
}
