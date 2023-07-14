package ss11_DSA_stack_queue.exercise.Queue.lien_ket_vong;

public class Main{
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(1);
        myQueue.enqueue(12);
        myQueue.enqueue(120);
        myQueue.enqueue(1200);
        System.out.println(myQueue.dequeue().data);
    }
}
