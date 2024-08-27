import java.util.ArrayList;
import java.util.List;

public class User {
    private static int userCount = 0;
    private String userID;
    private String name;
    private String address;
    private String contact;
    private String accountNumber;
    private double balance;
    private String password;
    private List<String> transactions;

    public User(String name, String address, String contact, String password, double initialDeposit) {
        this.userID = "U" + (++userCount);
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.password = password;
        this.accountNumber = generateAccountNumber();
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        addTransaction("Initial Deposit: " + initialDeposit);
    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void updateDetails(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    public void displayUserDetails() {
        System.out.println("UserID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public void viewAccountStatement() {
        System.out.println("Account Statement for " + name + " (Account: " + accountNumber + "):");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
