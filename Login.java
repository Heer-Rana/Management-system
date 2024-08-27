import java.util.HashMap;
import java.util.Map;

public class Login {
    private Map<String, User> userDatabase = new HashMap<>();

    public void registerUser(User user) {
        userDatabase.put(user.getAccountNumber(), user);
        System.out.println("User registered successfully. Account Number: " + user.getAccountNumber());
    }

    public User authenticate(String accountNumber, String password) {
        User user = userDatabase.get(accountNumber);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful.");
            return user;
        } else {
            System.out.println("Invalid account number or password.");
            return null;
        }
    }

    public User findUserByAccountNumber(String accountNumber) {
        return userDatabase.get(accountNumber);
    }
}
