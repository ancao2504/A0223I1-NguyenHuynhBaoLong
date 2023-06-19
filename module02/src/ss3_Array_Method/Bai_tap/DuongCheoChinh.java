package ss3_Array_Method.Bai_tap;

import java.util.Scanner;

public class DuongCheoChinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[][] array =new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int result=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    result+=array[i][j];
                }
            }

        }
        System.out.println("Result: " +result);
    }

}
