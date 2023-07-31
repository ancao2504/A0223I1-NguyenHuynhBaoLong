package CaseStudy.Exception;

public class CodeEmployeeException extends Exception {
    public CodeEmployeeException(String mess) {
        super(mess);
    }

    public static Boolean checkCodeEmployee(String codeEmployee) {
        String regex = "^NV-[0-9]{4}$";
        Boolean check = codeEmployee.matches(regex);

        try {
            if (check == false) {
                throw new CodeEmployeeException("code wrong format: NV-YYYY");
            }
        } catch (CodeEmployeeException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

}
