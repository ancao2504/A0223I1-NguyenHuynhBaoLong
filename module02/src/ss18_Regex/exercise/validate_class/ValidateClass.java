package ss18_Regex.exercise.validate_class;

public class ValidateClass {
    private static final String regexClass= "^[ACP][0-9]{4}[GHILKM]$";

    public static Boolean validate (String string) {
        if (string.matches(regexClass)) {
            return true;
        }
        return false;
    }
}
