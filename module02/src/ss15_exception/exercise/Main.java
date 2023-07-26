package ss15_exception.exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       CheckIllegalTriangleException checkIllegalTriangleException = new CheckIllegalTriangleException();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("side1: ");
            checkIllegalTriangleException.setSide1(Double.parseDouble(scanner.nextLine()));
            System.out.print("side1: ");
            checkIllegalTriangleException.setSide2(Double.parseDouble(scanner.nextLine()));
            System.out.print("side1: ");
            checkIllegalTriangleException.setSide3(Double.parseDouble(scanner.nextLine()));
        } catch (IllegalTriangleException e) {
           e.getMessage();
        }
    }
}
