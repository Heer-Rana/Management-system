import java.util.Scanner;

public class BankingSystem {
    private static Login login = new Login();
    private static Transaction transaction = new Transaction();
    private static AccountManager accountManager = new AccountManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Banking System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your address:");
        String address = scanner.nextLine();
        System.out.println("Enter your contact number:");
        String contact = scanner.nextLine();
        System.out.println("Set your password:");
        String password = scanner.nextLine();
        System.out.println("Enter initial deposit amount:");
        double initialDeposit = scanner.nextDouble();

        User newUser = new User(name, address, contact, password, initialDeposit);
        login.registerUser(newUser);
    }

    private static void loginUser(Scanner scanner) {
        System.out.println("Enter your account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        User user = login.authenticate(accountNumber, password);
        if (user != null) {
            userMenu(scanner, user);
        }
    }

    private static void userMenu(Scanner scanner, User user) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("Welcome, " + user.getAccountNumber());
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Account Statement");
            System.out.println("6. Update Account Details");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    accountManager.viewAccountDetails(user);
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    transaction.deposit(user, depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    transaction.withdraw(user, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Enter recipient's account number:");
                    String recipientAccount = scanner.nextLine();
                    System.out.println("Enter amount to transfer:");
                    double transferAmount = scanner.nextDouble();
                    User recipient = login.findUserByAccountNumber(recipientAccount);
                    if (recipient != null) {
                        transaction.transferFunds(user, recipient, transferAmount);
                    } else {
                        System.out.println("Invalid recipient account number.");
                    }
                    break;
                case 5:
                    user.viewAccountStatement();
                    break;
                case 6:
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new address:");
                    String newAddress = scanner.nextLine();
                    System.out.println("Enter new contact number:");
                    String newContact = scanner.nextLine();
                    accountManager.updateAccountDetails(user, newName, newAddress, newContact);
                    break;
                case 7:
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
