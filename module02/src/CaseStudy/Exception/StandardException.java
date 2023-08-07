package CaseStudy.Exception;

public class StandardException extends Exception {
    public StandardException(String mess) {
        super(mess);
    }

    public static boolean checkStandard(String standard) {
        String regex = "^trung cap$|^cao dang$|^dai hoc$|^sau dai hoc$";
        boolean check = standard.matches(regex);
        try {
            if (check == false) {
                throw new StandardException("trung cap | cao dang| dai hoc| sau dai hoc");
            }
        } catch (StandardException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
