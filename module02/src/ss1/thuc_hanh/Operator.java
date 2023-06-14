package ss1.thuc_hanh;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float weight;
        float height;

        System.out.println("Enter weight = " );
        weight = scanner.nextFloat();

        System.out.println("Enter height = ");
        height = scanner.nextFloat();

        float area = weight * height;
        System.out.println("Area = " + area);

    }
}
