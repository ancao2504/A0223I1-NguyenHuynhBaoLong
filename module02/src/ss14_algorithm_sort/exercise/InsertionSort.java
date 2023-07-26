package ss14_algorithm_sort.exercise;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] number = {9,4,1,3,2,7,5,10,8};
        insertionSort(number);
        System.out.println(Arrays.toString(number));
    }

    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i-1;
            while (j >= 0 && key < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}
