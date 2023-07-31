package CaseStudy.Exception;

public class NameException extends Exception{
    public NameException(String mess) {
        super(mess);
    }


    public static Boolean checkName (String name) {
        String regex = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
        boolean check = name.matches(regex);
        try {
            if (check == false){
                throw new NameException("name isn't format: Nguyen Van A");
            }
        }catch (NameException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
