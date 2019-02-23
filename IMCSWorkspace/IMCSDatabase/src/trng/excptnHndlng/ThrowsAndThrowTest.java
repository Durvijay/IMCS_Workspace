package trng.excptnHndlng;

public class ThrowsAndThrowTest {

	public static void main(String[] args) {
		
		try {
			String ssnNo = args[0];
			validateSSNNo(ssnNo);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception occured" + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Exception occured" + e.getMessage());
			e.printStackTrace();
		} catch (SSNValidException se) {
			System.out.println("Error to validate SSN" + se.getMessage());
			se.printStackTrace();
		} finally {
				System.out.println("Finally block");
		}
		
		//Next set of sttatements
	}
		
		
	static boolean validateSSNNo(String ssnNo) throws SSNValidException { //Needs to have throws on SSNValidException if it is checked exception.
		
		try {
			Long.parseLong(ssnNo);
		} catch (NumberFormatException e) {
			throw new SSNValidException("Not valid number");
		}
		
		if (ssnNo.length() != 10) {
			throw new SSNValidException("Invalid Lenght");
		}
		
		//this statement won't execute if SSNValidException occurs
		return true;
	}
}


