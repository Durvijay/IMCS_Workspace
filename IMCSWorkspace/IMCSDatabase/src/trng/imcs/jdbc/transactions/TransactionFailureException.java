package trng.imcs.jdbc.transactions;

import java.sql.SQLException;

/**
 * Created by Manohar on 12/28/2016.
 */
public class TransactionFailureException extends Throwable {
    public TransactionFailureException(String message, SQLException sqle) {
        super(message, sqle);
    }

    public TransactionFailureException(String message, InvalidAccountException e) {
        super(message, e);
    }

    public TransactionFailureException(String s, Exception e) {
        super(s, e);
    }
}
