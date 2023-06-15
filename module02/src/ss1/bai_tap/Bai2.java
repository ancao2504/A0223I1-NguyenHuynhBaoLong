package ss1.bai_tap;

import java.util.Scanner;

public class Bai2 {
    final static String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    final static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void readNum(int number,String world) {

        System.out.print(number > 19 ? tens[number / 10]:ones[number]);
        System.out.print(number >0? " "+world: "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number");
        int number = scanner.nextInt();
        readNum((number/100)%10,"hundered");
        readNum((number%100),"");
    }

}
