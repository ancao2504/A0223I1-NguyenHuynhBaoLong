package ss3_Array_Method.Bai_tap;

import java.util.Scanner;

public class PlusElement {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 13, 2};
        Scanner scanner = new Scanner(System.in);
        System.out.println("vị trí cần chèn!");
        int index = scanner.nextInt();
        System.out.println("giá trị cần chèn!");
        int val = scanner.nextInt();
        for (int i = arr.length - 1; i >= index; i--) {
            if (i == index) {
                arr[i] = val;
                break;
            }
            int temp = arr[i - 1];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +"\t");
        }
    }
}
