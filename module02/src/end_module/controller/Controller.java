package end_module.controller;

import java.util.Scanner;

public class Controller {
    private  static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        boolean check=true;
        while (check) {
            System.out.println("-------------Main Menu------------");
            System.out.println("1.");
            System.out.println("2.");
            System.out.println("3.");
            System.out.println("4.");
            System.out.println("5.");
        }
    }
}
