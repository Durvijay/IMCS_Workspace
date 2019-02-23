package trng.excptnHndlng;

public class ExceptionHandlingTest {

	public static void main(String[] args) {
		
		try {
			String ssnNo = args[0];
			validateSSNNo(ssnNo);
		} /*catch (Exception e) { //Can't have 
			System.out.println("Exception occured" + e.getMessage());
		} */
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
		
		System.out.println("After try blocks");
	}
		
		
	static boolean validateSSNNo(String ssnNo) throws SSNValidException { //Needs to have throws on SSNValidException if it is checked exception.
		
		try {
			Long.parseLong(ssnNo);
			System.out.println(" This statement will execute only if no excpetion occurs in above statement");
		} catch (NumberFormatException e) {
			throw new SSNValidException("Not valid ssn number, should be numbric data only", e);
		}
		
		if (ssnNo.length() != 9) {
			System.out.println("Before throw.");
			throw new SSNValidException("SSN Number is not with valid lenght");
//			System.out.println("After throw.");
		}
		
		return true;
	}
}

