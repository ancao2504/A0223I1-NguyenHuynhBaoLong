package ss14_algorithm_sort.practice;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {9,10,4,1,6,3,7,2,8,5};
        System.out.println(Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void bubbleSort(int[] array) {
        Boolean flag=true;
        for (int i = 0; i < array.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < array.length - 1-i; j++) {
                if (array[j] > array[j + 1]) {
                   int temp = array[j];
                   array[j] = array[j +1];
                   array[j+1] = temp;
                   flag = true;
                }
            }
        }
    }
}
