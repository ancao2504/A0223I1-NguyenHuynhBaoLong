package ss1.thuc_hanh;

import java.util.Scanner;

public class BodyWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight,height;


        System.out.print("Enter your weight: ");
        weight = scanner.nextFloat();
        System.out.print("Enter your height: ");
        height = scanner.nextFloat();
        double BMI = weight/Math.pow(height,2);

        if (BMI < 18.5) {
            System.out.println("Underweight");
        } else if (18.5 <= BMI && BMI < 25.0) {
            System.out.println("Normal");
        } else if ( 25.0 <= BMI && BMI < 30.0) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
