public class Transaction {
    public void deposit(User user, double amount) {
        user.setBalance(user.getBalance() + amount);
        user.addTransaction("Deposit: +" + amount + ", New Balance: " + user.getBalance());
        System.out.println("Deposit successful. New Balance: " + user.getBalance());
    }

    public void withdraw(User user, double amount) {
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            user.addTransaction("Withdrawal: -" + amount + ", New Balance: " + user.getBalance());
            System.out.println("Withdrawal successful. New Balance: " + user.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transferFunds(User sender, User receiver, double amount) {
        if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            sender.addTransaction("Transferred to " + receiver.getAccountNumber() + ": -" + amount + ", New Balance: " + sender.getBalance());
            receiver.addTransaction("Received from " + sender.getAccountNumber() + ": +" + amount + ", New Balance: " + receiver.getBalance());
            System.out.println("Transfer successful. New Balance: " + sender.getBalance());
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
}
