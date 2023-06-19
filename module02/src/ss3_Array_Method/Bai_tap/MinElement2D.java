package ss3_Array_Method.Bai_tap;

import java.util.Scanner;

public class MinElement2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        int[][] array =new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] =scanner.nextInt();
            }
        }
        int max = array[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Giá trị lớn nhất là: " +max );
    }
}
