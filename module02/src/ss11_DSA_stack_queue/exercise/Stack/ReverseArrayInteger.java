package ss11_DSA_stack_queue.exercise.Stack;

import java.util.Stack;

public class ReverseArrayInteger {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arrayInteger = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = 0;
        for (Integer integer : arrayInteger) {
            stack.push(integer);
        }

        while (!stack.isEmpty()) {
            arrayInteger[i] = stack.pop();
            i++;
        }

        for (Integer integer : arrayInteger) {
            System.out.print(integer + " ");
        }

    }


}
