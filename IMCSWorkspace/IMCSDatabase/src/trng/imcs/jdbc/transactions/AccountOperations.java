package trng.imcs.jdbc.transactions;

import java.sql.SQLException;

/**
 * Created by Manohar on 12/28/2016.
 */
public interface AccountOperations {

    Account findAccount(int accountId) throws SQLException;

    boolean withdraw(int accountId, float amount) throws SQLException, InsufficientFundsException, TransactionFailureException;

    boolean deposit(int accountId, float amount) throws TransactionFailureException;

    boolean processTransaction(int sourceAccountId, int targetAccountId, float transactionAmount) throws InsufficientFundsException, TransactionFailureException;
}
