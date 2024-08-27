public class AccountManager {
    public void viewAccountDetails(User user) {
        user.displayUserDetails();
    }

    public void updateAccountDetails(User user, String name, String address, String contact) {
        user.updateDetails(name, address, contact);
        System.out.println("Account details updated successfully.");
    }
}
