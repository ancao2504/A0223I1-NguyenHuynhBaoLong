package ss12_Map_Tree.practice.hashMap_hashSet;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Long",19, "h02/09");
        Student student1 = new Student("Dao",19, "h02/09");
        Student student2 = new Student("Dat",23, "h02/09");

//        Map<Integer,Student> hashMap = new HashMap<Integer,Student>();
//        hashMap.put(1,student);
//        hashMap.put(3,student2);
//        hashMap.put(2,student1);
//
//        for (Map.Entry<Integer,Student> studentEntry : hashMap.entrySet()) {
//            System.out.println(studentEntry.getValue());
//        }

        System.out.println("--------------Set------------");
        Set<Student> hashSet = new HashSet<Student>();
        hashSet.add(student);
        hashSet.add(student1);
        hashSet.add(student2);


        for (Student stu : hashSet) {
            System.out.println(stu);
        }

    }
}
