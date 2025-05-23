import java.util.Scanner;


class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

public class PasswordValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = sc.nextLine();

        try {
            validatePassword(password);
            System.out.println(" Password is valid.");
        } catch (PasswordException e) {
            System.out.println("Invalid! " + e.getMessage());
        }

        sc.close();
    }

   
    public static void validatePassword(String pass) throws PasswordException {
        if (pass.length() < 8) {
            throw new PasswordException("Password must be at least 8 characters long.");
        }
        if (!pass.matches(".*[A-Z].*")) {
            throw new PasswordException("Password must contain at least one uppercase letter.");
        }
        if (!pass.matches(".*\\d.*")) {
            throw new PasswordException("Password must contain at least one number.");
        }
        if (!pass.matches(".*[!@#$].*")) {
            throw new PasswordException("Password must contain at least one special character (!@#$).");
        }
        if (pass.contains(" ")) {
            throw new PasswordException("Password must not contain spaces.");
        }
    }
}
