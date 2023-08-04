package CaseStudy.Exception;

public class EmailException extends Exception {
    public EmailException(String mess) {
        super(mess);
    }

    public static Boolean checkEmail(String email) {
        String regex = "^[a-z0-9]+@[a-z]+\\.com$";
        Boolean check = email.matches(regex);
        try {
            if (check == false) {
                throw new EmailException("format: jonh@gmail.com");
            }
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
