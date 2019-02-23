package trng.imcs.jdbc.transactions;

/**
 * Created by Manohar on 12/28/2016.
 */
public class InsufficientFundsException extends Throwable {
    public InsufficientFundsException(String s) {
        super(s);
    }
}
