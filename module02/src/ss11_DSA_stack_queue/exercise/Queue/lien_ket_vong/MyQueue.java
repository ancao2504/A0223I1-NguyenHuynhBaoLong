package ss11_DSA_stack_queue.exercise.Queue.lien_ket_vong;

public class MyQueue extends Node {
    private Node front;
    private Node rear;

    public MyQueue(int data) {
        super(data);
    }

    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.front == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    public Node dequeue() {
        if (this.front == null)
            return null;
        Node temp = this.front;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        return temp;
    }
}
