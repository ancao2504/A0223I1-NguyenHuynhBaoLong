package ss1.thuc_hanh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Linear equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c ', please enter constant: ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("a= ");
        double a = scanner.nextDouble();

        System.out.print("b= ");
        double b = scanner.nextDouble();

        System.out.print("c= ");
        double c = scanner.nextDouble();

        if (a != 0) {
            double result = (c - b) / a;
            System.out.println("Result = " + result);
        } else {
            if (b == c) {
                System.out.println("The solution is all x!");
            } else {
                System.out.println("No solution!");
            }
        }
    }
}
