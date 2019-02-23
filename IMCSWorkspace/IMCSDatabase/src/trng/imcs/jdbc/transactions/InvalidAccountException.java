package trng.imcs.jdbc.transactions;

/**
 * Created by Manohar on 12/28/2016.
 */
public class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}
