package CaseStudy.Exception;

public class IDEmployeeException extends Exception{
    public IDEmployeeException ( String mess) {
        super(mess);
    }

    public static Boolean checkID(String ID) {
        String regex = "^[0-9]{9}$|^[0-9]{12}$";
        Boolean check = ID.matches(regex);
        try{
            if (check == false) {
                throw new IDEmployeeException("ID wrong format, your id must enough 9 or 12 number");
            }
        }catch (IDEmployeeException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
