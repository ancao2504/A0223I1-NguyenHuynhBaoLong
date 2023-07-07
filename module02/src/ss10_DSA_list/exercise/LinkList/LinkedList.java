package ss10_DSA_list.exercise.LinkList;

public class LinkedList <E> {
    private Node head;
    private int numNodes = 0;


    public LinkedList(E data) {
        head=new Node(data);
    }

    public LinkedList() {

    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data=data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add (int index, Object data) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index -1 && temp.next !=null; i++) {
            temp=temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next=holder;
        numNodes++;
    }
    
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next=temp;
        numNodes++;
    }
    public void addLast(E element) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data );
            temp = temp.next;
        }

    }

    public E remove(int index) {
        Node temp = head;

        for (int i = 0; i < index-1; i++) {
            temp=temp.next;
        }
        E removeData =(E) temp.next.data;
        temp.next= temp.next.next;
        numNodes--;
        return removeData;
    }

    public LinkedList<E> clone() {
        if (numNodes == 0) {
            throw new NullPointerException("This linked list return null.");
        }
        LinkedList<E> returnLinkedList = new LinkedList<>();

        Node temp = head;
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;

        while (temp != null) {
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public E getFirst() {
        Node temp=head;
        if (numNodes == 0) {
            throw new NullPointerException("This linked list return null");
        }
        return (E) temp.getData();
    }

    public E getLast() {
        Node temp = head;
        if (numNodes == 0) {
            throw new NullPointerException("this linked list return null");
        }
        while (temp != null) {
            temp=temp.next;
        }
        return (E) temp.getData();
    }

    public void clear() {
        head = null;
        numNodes=0;
    }

    public int size() {
        return numNodes;
    }

    public Boolean contain(E e) {
        Node temp=head;
        while (temp!=null){
            if (e == temp.data) {
                return true;
            } else {
                temp=temp.next;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if(e == temp.data) {
                return Integer.parseInt("index is: "+i);
            }
            temp=temp.next;
        }
        return -1;
    }

    public E get(int i) {
        Node temp = head;
        for (int j = 0; j < i; j++) {
            temp= temp.next;
        }
        return (E) temp.data;
    }
}
