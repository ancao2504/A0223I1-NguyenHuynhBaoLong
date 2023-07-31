package ss18_Regex.exercise.validate_phone_number;

public class ValidatePhoneNumber {
    private static final String regexPhoneNumber = "^\\([0-9]{2}\\)-\\([0-9]{10}\\)$";

    public static Boolean validate (String string) {
        if (string.matches(regexPhoneNumber)) {
            return true;
        }
        return false;
    }
}
