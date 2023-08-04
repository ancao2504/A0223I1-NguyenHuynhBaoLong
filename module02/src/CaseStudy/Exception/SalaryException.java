package CaseStudy.Exception;

public class SalaryException extends Exception{
    public SalaryException (String mess) {
        super(mess);
    }

    public static Boolean chechSalary(double salary) {
        String regex = "^[0-9]+&";
        Boolean check =(String.valueOf(salary)).matches(regex);
        try{
            if (check == false) {
                throw new SalaryException("nhập số lớn hơn 0");
            }
        }catch (SalaryException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
