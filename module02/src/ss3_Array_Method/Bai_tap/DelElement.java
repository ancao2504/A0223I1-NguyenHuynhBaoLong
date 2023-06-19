package ss3_Array_Method.Bai_tap;

import java.util.Scanner;

public class DelElement {
    public static void main(String[] args) {
        int[] arr={10,9,6,3,12};
        Scanner scanner = new Scanner(System.in);
        int valueDel = scanner.nextInt();
        int indexDel=0;
        // tìm phần tử cần xóa
        for (int i = 0; i < arr.length; i++) {
            if (valueDel == arr[i]) {
                 indexDel = i;
                break;
            }
        }
        // xóa phần tử
        for (int i =indexDel ; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
            arr[i+1]=0;

        }
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
    }
}
