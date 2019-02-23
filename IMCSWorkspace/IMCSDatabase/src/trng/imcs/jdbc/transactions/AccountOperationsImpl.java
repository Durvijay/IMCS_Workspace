package trng.imcs.jdbc.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Manohar on 12/28/2016.
 */
public class AccountOperationsImpl implements AccountOperations {

    Connection connection;

    {
        try {
            connection = createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findAccount(int accountId) throws SQLException {
        //db operations
        PreparedStatement statement = connection.prepareStatement("select accountId, name, balance from imcs.Account where accountId = ? ");
        statement.setInt(1, accountId);
        ResultSet resultSet = statement.executeQuery();
        //use resultset
        if (resultSet.next()) {
            Account account = new Account();
            account.setAccountId(resultSet.getInt(1));
            account.setName(resultSet.getString(2));
            account.setBalance(resultSet.getFloat(3));
            return account;
        }

        return null;
    }

    @Override
    public boolean withdraw(int accountId, float amount) throws InsufficientFundsException, TransactionFailureException {
        try {
            //db operations
            PreparedStatement statement = connection.prepareStatement("update imcs.Account set balance = ? where accountId = ?");
            Account account = findAccount(accountId);

            if (account == null) {
                throw new InvalidAccountException("Account not exist" + accountId);
            }
            //check the balance is sufficient to deduct
            if (account.getBalance() <= amount) {
                throw new InsufficientFundsException("No found to withdraw");
            }
            statement.setFloat(1, account.getBalance() - amount);
            statement.setInt(2, accountId);
            int recordsUpdated = statement.executeUpdate();
            if (recordsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            throw new TransactionFailureException("Withdraw failed ", sqle);
        } catch (InvalidAccountException e) {
            throw new TransactionFailureException("Withdraw failed ", e);
        }
    }

    @Override
    public boolean deposit(int accountId, float amount) throws TransactionFailureException {
        try {
            //db operations
            PreparedStatement statement = connection.prepareStatement("update imcs.Account set balance = ? where accountId = ?");
            Account account = findAccount(accountId);

            if (account == null) {
                throw new InvalidAccountException("Account not exist" + accountId);
            }

            statement.setFloat(1, account.getBalance() + amount);
            statement.setInt(2, accountId);
            int recordsUpdated = statement.executeUpdate();
            if (recordsUpdated > 0) {
                createLog(account, amount);
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            throw new TransactionFailureException("Withdraw failed ", sqle);
        } catch (InvalidAccountException e) {
            throw new TransactionFailureException("Withdraw failed ", e);
        }

    }

    @Override
    public boolean processTransaction(int sourceAccountId, int targetAccountId, float transactionAmount) throws InsufficientFundsException, TransactionFailureException {
        boolean success;

        try {
            connection.setAutoCommit(false);
            //withdraw the balance
            withdraw(sourceAccountId, transactionAmount);

            //deposit the account
            deposit(targetAccountId, transactionAmount);

            connection.commit();
            success = true;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new TransactionFailureException("Transaction failure", e);
            }
            success = false;
            throw new TransactionFailureException("Transaction failure", e);
        }

        return success;
    }

    private boolean createLog(Account account, float amount) throws TransactionFailureException {
        boolean success;

        try {
            //db operations
            PreparedStatement statement =
                    connection.prepareStatement("insert into imcs.TransactionsLog (fromAccount, transactionDate, transactionAmount, comments) values (?, ?, ?, ?) ");
            statement.setInt(1, account.getAccountId());
            statement.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            statement.setFloat(3, amount);
            statement.setString(4, "Transaction for the amount " + amount);

            if(statement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            throw new TransactionFailureException("Unable to create TransactionLog", sqle);
        }
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
        //register driver
        Class.forName("com.mysql.jdbc.Driver");

        //establish connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "root");

        return connection;
    }
}
