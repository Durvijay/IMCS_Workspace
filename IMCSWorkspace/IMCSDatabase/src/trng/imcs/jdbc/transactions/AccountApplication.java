package trng.imcs.jdbc.transactions;

import trng.imcs.jdbc.transactions.Account;

/**
 * Created by Manohar on 12/28/2016.
 */
public class AccountApplication {

    public static void main(String[] args) throws InsufficientFundsException, TransactionFailureException {
        AccountOperations accountOperations = new AccountOperationsImpl();
        int fromAcct = 1001;
        int toAccount = 2001;
        float transactionAmount = 120;
        accountOperations.processTransaction(fromAcct, toAccount, transactionAmount);
    }

}
