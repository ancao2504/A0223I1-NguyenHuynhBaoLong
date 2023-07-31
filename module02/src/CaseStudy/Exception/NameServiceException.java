package CaseStudy.Exception;

public class NameServiceException extends Exception {
    public NameServiceException(String mess) {
        super(mess);
    }

    public static boolean checkNameService(String name) {
        String regexNam = "^[A-Z][a-z]+$";
        boolean check = name.matches(regexNam);

        try {
            if (check == false) {
                throw new NameServiceException("chữ cái đầu viết hoa ");
            }
        } catch (NameServiceException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
