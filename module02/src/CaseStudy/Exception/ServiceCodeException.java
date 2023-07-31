package CaseStudy.Exception;

public class ServiceCodeException extends Exception {
    public ServiceCodeException(String mess) {
        super(mess);
    }

    public static Boolean checkCode(String code) {
        String regexCode = "^SV(VL|HO|RO)-[0-9]{4}$";
        boolean check = code.matches(regexCode);
        try {
            if (check==false) {
                throw new ServiceCodeException("SVXX-YYYY");
            }
        } catch (ServiceCodeException serviceCode) {
            System.out.println(serviceCode.getMessage());
        }
        return check;
    }
}
