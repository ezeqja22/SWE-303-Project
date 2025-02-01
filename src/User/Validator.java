package User;

public class Validator {

    public static boolean isValidAge(int age) {
        return age >= 18 && age <= 60;
    }

    public static boolean isValidUsername(String username) {
        return username != null && username.length() >= 5 && username.length() <= 15;
    }

    public static boolean isValidTransactionAmount(double amount) {
        return amount >= 10 && amount <= 10000;
    }
}
