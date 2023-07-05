package ss10_DSA_list.practice.link_list_basic;

import javax.xml.soap.Node;

public class LinkList {
    private Node head;
    private int numNodes;

    public LinkList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node (Object data) {
            this.data=data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void add (int index, Object data) {
        Node temp=head;
        Node holder;

        for (int i = 0; i < index -1 && temp.next !=null; i++) {
            temp=temp.next;
        }
        holder = temp.next;
        temp.next=new Node(data);
        temp.next.next=holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
