package ss18_Regex.practice.validate_email;

public class Main {
    public static void main(String[] args) {
        String[] email = {"@123.com","1a@a.com","long8@gmail.com"};

        for (String string : email) {
            if (ValidateEmail.validate(string)) {
                System.out.println(string +" "+ true);
            } else {
                System.out.println(string +" "+ false);
            }
        }
    }
}
