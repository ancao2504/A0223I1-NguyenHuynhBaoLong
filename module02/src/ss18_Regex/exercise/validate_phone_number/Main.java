package ss18_Regex.exercise.validate_phone_number;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("enter phone number: ");
        String phoneNumber = new Scanner(System.in).nextLine();

        if (ValidatePhoneNumber.validate(phoneNumber)) {
            System.out.println("phone number: "+phoneNumber+" is valid");
        }else {
            System.out.println("phone number: "+phoneNumber+" is not valid");
        }
    }
}
