package ss3_Array_Method.Thuc_hanh;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int max =array[0];
        for (int j = 1; j < array.length; j++) {
            if (max < array[j]) {
                max = array[j];
            }
        }
        System.out.println("Max element is: " + max);
    }
}
