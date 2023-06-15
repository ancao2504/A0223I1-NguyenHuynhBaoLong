package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class interst_calculator {
    public static void main(String[] args) {
        double money=1.0;
        int month=1;
        double interestRate = 1.0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        money = scanner.nextDouble();
        System.out.print("Enter number of month: ");
        month = scanner.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        interestRate = scanner.nextDouble();

        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("total interest: " +totalInterest);

    }
}
