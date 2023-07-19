package ss13_algorithm_search.practice.optional;

import java.util.Scanner;

public class Recursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = {1, 5, 0, -3, 12, 3, 6, 9, 2, 8, 4, 11, 13};
        System.out.println(recursiveSearch(number,8,0,number.length-1));
    }

    public static int recursiveSearch(int[] numbers, int x, int left, int right) {
        int mid;
        if (left < right) {
            mid = (right + left) / 2;
            if (numbers[mid] == x) {
                return mid;
            } else if (x > numbers[mid]) {
                return recursiveSearch(numbers, x, mid + 1, right);
            } else {
                return recursiveSearch(numbers, x, left, mid - 1);
            }
        } else {
            return -1;
        }
    }
}
