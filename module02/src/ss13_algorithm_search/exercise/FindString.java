package ss13_algorithm_search.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class FindString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một chuỗi kí tự: ");
        String input = scanner.nextLine();

        String longestSubstring = findLongestSubstringByASCII(input);
        System.out.println("Chuỗi con có độ dài lớn nhất theo thứ tự ASCII là: " + longestSubstring);
    }

    public static String findLongestSubstringByASCII(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        String longestSubstring = "";
        String currentSubstring = String.valueOf(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar >=input.charAt(i - 1)){
                currentSubstring += input.charAt(i);
            }else{
                if (longestSubstring.length() < currentSubstring.length()) {
                    longestSubstring = currentSubstring;

                }
                currentSubstring = String.valueOf(currentChar);
            }
        }
        if (longestSubstring.length() < currentSubstring.length()) {
            longestSubstring = currentSubstring;
        }
        return longestSubstring;
    }
}


