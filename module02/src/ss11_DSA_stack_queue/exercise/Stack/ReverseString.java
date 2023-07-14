package ss11_DSA_stack_queue.exercise.Stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Nguyễn Long";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        StringBuilder stringBuilder=new StringBuilder();

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.pop());
        }

        System.out.println(stringBuilder.toString());
    }
}
