package ss18_Regex.practice.validate_email;

import java.util.Scanner;

public class ValidateEmail {
    private static final String regexEmail = "^[a-z0-9]+@[a-z0-9]+\\.[a-z]+$";

    public static Boolean validate (String string) {
        if (string.matches(regexEmail)) {
            return true;
        }
        return false;
    }

}
