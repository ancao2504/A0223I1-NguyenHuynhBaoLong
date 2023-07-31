package ss18_Regex.exercise.validate_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("enter name class: ");
        String nameClass = new Scanner(System.in).nextLine();

        if (ValidateClass.validate(nameClass)) {
            System.out.println("class name: "+nameClass+" is valid");
        } else {
            System.out.println("class name: "+nameClass+" is not valid");
        }
    }
}
