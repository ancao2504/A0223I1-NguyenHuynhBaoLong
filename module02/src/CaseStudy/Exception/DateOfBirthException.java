package CaseStudy.Exception;

public class DateOfBirthException extends Exception{
    public DateOfBirthException (String mess) {
        super(mess);
    }

    public static Boolean checkDateOfBirth (String date) {
        String regex = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$";
        Boolean check = date.matches(regex);
        try{
            if (check == false) {
                throw new DateOfBirthException("format: dd//mm//yyyy");
            }
        } catch (DateOfBirthException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
