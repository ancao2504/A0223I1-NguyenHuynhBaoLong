package end_module.exception;

public class DateOfBirthException extends Exception {
    public DateOfBirthException (String mess) {
        super(mess);
    }

    public static Boolean checkDateOfBirth (String date) {
        String regex = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$";
        Boolean check = date.matches(regex);
        try{
            if (check == false) {
                throw new CaseStudy.Exception.DateOfBirthException("định dạng: dd/mm/yyyy");
            }
        } catch (CaseStudy.Exception.DateOfBirthException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
