package ss14_algorithm_sort.practice;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {9, 10, 4, 1, 6, 3, 7, 2, 8, 5};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int min = list[i];
            int min_index = i;

            for (int j = i + 1; j < list.length; j++) {
                if (min > list[j]) {
                    min = list[j];
                    min_index = j;
                }
            }
            if (min_index != i) {
                list[min_index] = list[i];
                list[i] = min;
            }
        }
    }
}
