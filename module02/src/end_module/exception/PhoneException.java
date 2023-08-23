package end_module.exception;

public class PhoneException extends Exception{
    public PhoneException (String mess) {
        super(mess);
    }

    public static Boolean checkPhoneNumber (String phoneNumber) {
        String regex = "^(090)+[0-9]{7}$|^(091)+[0-9]{7}$";
        Boolean check = phoneNumber.matches(regex);
        try{
            if (check == false) {
                throw new PhoneException("Số phải đủ 10 số bà bắt đầu bằng 090 hoặc 091");
            }
        } catch (PhoneException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
