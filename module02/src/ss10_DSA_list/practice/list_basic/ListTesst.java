package ss10_DSA_list.practice.list_basic;

public class ListTesst {
    public static void main(String[] args) {
        List <Integer> listInteger = new List<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: "+listInteger.get(3));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));
//        listInteger.get(6);
//        System.out.println("element 6: "+listInteger.get(6));
    }
}
