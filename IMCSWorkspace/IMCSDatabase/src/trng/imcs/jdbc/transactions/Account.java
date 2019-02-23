package trng.imcs.jdbc.transactions;

/**
 * Created by Manohar on 12/28/2016.
 */
public class Account {
    int accountId;
    String name;
    float balance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
