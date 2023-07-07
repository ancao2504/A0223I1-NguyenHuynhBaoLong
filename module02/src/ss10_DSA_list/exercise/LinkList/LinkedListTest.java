package ss10_DSA_list.exercise.LinkList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList (1);
        ll.add(1,2);
        ll.add(2,3);
        ll.add(3,4);
        ll.add(4,5);
        ll.addFirst(100);
        ll.addLast(200);
//        System.out.println("data remove "+ll.remove(1));
//        ll.printList();
//
//        System.out.println(ll.clone());
//
//        ll.clear();
        ll.printList();
        System.out.println(ll.get(0));

    }
}
