package ss18_Regex.practice.validate_acc;

public class Main {
    public static void main(String[] args) {
        String[] account = {"long123_a","bbbb_","123ac"};

        for (String string: account) {
            if (ValidateAccount.validate(string)) {
                System.out.println(string +" accept");
            } else {
                System.out.println(string +" not accept");
            }
        }
    }
}
