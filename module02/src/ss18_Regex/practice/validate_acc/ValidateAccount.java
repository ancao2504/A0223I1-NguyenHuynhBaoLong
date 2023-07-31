package ss18_Regex.practice.validate_acc;

public class ValidateAccount {
    private static final String regexAccount = "^[_a-z0-9]{6,}$";

    public static Boolean validate (String string) {
        if (string.matches(regexAccount)) {
            return true;
        }
        return false;
    }
}
