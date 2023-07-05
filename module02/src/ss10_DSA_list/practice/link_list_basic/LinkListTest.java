package ss10_DSA_list.practice.link_list_basic;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList ll = new LinkList(1);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4,9);
        ll.add(3,99);
        ll.printList();
    }
}
