package ss11_DSA_stack_queue.optional.binary;

import java.util.Scanner;
import java.util.Stack;

public class ConvertToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();

        while (input != 0) {
            stack.push(input % 2) ;
            input= input/2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }


}
