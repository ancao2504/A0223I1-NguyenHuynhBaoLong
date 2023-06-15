package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class greate_common_factor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter value of a");
        int a = scanner.nextInt();
        System.out.print("enter value of b");
        int b = scanner.nextInt();

        a=Math.abs(a);
        b=Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("NO greatest common factor");
        }
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.print("Greatest common factor is: " + a);
    }
}
