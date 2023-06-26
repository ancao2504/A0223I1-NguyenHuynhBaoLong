package ss3_Array_Method.Bai_tap;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row=0;
        System.out.print("bạn muốn tính tổng ở cột mấy: ");
        row = scanner.nextInt();
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int sum=0;
        for (int i = 0; i < 3; i++) {
            sum+=arr[i][2];
        }
        System.out.println(sum);

    }
}
