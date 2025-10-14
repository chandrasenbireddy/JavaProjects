
public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        }
        else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        balance -= amount;
        System.out.println("Withdrew: " + amount);
        System.out.println("New Balance: " + balance);
    }
    public void getBalanceInfo() {
        System.out.println("Current Balance: " + balance);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
