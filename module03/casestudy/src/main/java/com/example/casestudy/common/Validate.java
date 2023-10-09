package com.example.casestudy.common;

public class Validate {
     private static String regex = "";
    public static boolean checkIdCardCustomer(String idCard) {
         regex = "^[0-9]{9}||[0-9]{12}$";
        return idCard.matches(regex);
    }

    public static boolean checkPhone(String phoneNumber) {
        String regex = "^090[0-9]{7}||091[0-9]{7}||\\+8490[-0-9]{7}||\\+8491[0-9]{7}$";
        return phoneNumber.matches(regex);
    }
    public static boolean checkEmail(String email) {
         regex = "^[a-z0-9]+@[a-z]+\\.com$";
         return email.matches(regex);
    }

}
