package trng.inheritence;

/**Super class */
class Bank {
	int amt;
	Bank(int pri) {
		amt = pri;
	}
	
	Bank () {
		amt = 0;
	}
	
	void deposit(int amt) {
		this.amt = this.amt + amt;
	}
}

/** Sub Class inheriting the Bank class */
class ICICIBank extends Bank {
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
	
	int calcInt() {
		return (amt * 12 * 2) / 100;
	}
	
	ICICIBank updateMe() {
		this.location = "Modified Location";
		return this;
	}
	
}

class InherTest {
	public static void main(String args[]) {
		ICICIBank oc = new ICICIBank(2000, "India");
		System.out.println("Total amount : " + oc.amt); //The object OC can access properties from super class.
		System.out.println("Bank Location: " + oc.location);
		System.out.println("Interest: " + oc.calcInt());		
		
		oc = oc.updateMe();
		
		System.out.println("Bank Location: " + oc.location);
	}
}