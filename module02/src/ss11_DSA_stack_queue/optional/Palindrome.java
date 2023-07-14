package ss11_DSA_stack_queue.optional.binary;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Character> queue = new LinkedList<>();
        String input = scanner.nextLine();
        for (int i = input.length()-1; i >=0; i--) {
            queue.add(input.charAt(i));
        }
        String result="";
        while (!queue.isEmpty()) {
            result+=queue.remove();
        }

        if (result.equals(input)) {
            System.out.println("This string:  is a palindrome");
        } else {
            System.out.println("This string: is NOT a palindrome");
        }
    }

}
