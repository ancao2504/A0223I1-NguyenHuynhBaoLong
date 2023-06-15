package ss1.bai_tap;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        final double rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many dollar you want change?");
        double dollar = scanner.nextDouble();
        double vnd = dollar * rate;
        System.out.println("VND: "+ vnd);
    }
}
