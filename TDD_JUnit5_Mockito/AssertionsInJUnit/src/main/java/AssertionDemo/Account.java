package AssertionDemo;

public class Account {
    private String accountId;
    private double balance;
    private String holderName;

    public Account(String accountId, double balance, String holderName) {
        this.accountId = accountId;
        this.balance = balance;
        this.holderName = holderName;
    }

    public String getAccountId() { return accountId; }
    public double getBalance() { return balance; }
    public String getHolderName() { return holderName; }

    public boolean isOverdrawn() {
        return balance < 0;
    }
}