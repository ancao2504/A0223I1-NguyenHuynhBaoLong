package end_module.exception;

public class NameException extends Exception{
    public NameException(String mess) {
        super(mess);
    }

    public static Boolean checkName (String name) {
        String regex = "^[A-Za-z]{4,50}$";
        Boolean check = name.matches(regex);
        try{
            if (check == false) {
                throw new NameException("Tên có ít nhất 4 kí tự và nhiều nhất 50");
            }
        } catch (NameException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
