package CaseStudy.Exception;

public class GenderException extends Exception{
    public GenderException(String mess) {
        super(mess);
    }

    public static Boolean checkGender(String gender) {
        String regex= "^nam$|^nu$";
        boolean check = gender.matches(regex);
        try{
            if (check == false) {
                throw new GenderException("nam or nu");
            }
        } catch (GenderException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
