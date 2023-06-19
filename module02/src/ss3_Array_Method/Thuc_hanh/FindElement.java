package ss3_Array_Method.Thuc_hanh;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        boolean isExit = false;
        for (int i = 0; i < students.length; i++) {
            if(students[i] == name) {
                System.out.println("Position of the students in the list " + name + " is: " + (i + 1));
                isExit = true;
                break;
            }
        }
        if (!isExit) {
            System.out.println("Not found" + name + " in the list.");
        }
    }
}
