package ss11_DSA_stack_queue.optional;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demerging{
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("c");
        queue.add("a");
        queue.add("d");
        queue.add("b");


        System.out.println(queue);
    }
}
