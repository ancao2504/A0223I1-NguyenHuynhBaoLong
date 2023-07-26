package CaseStudy.controller;

import CaseStudy.model.Employee;
import CaseStudy.service.IEmployeeService;
import CaseStudy.service.impl.EmployeeService;

import java.util.Scanner;

public class Controller {
    private  static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService iEmployeeService = new EmployeeService();

    public static void mainMenu() {
        Boolean check = true;
        while (check) {
            System.out.println("-------------Main Menu------------");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter service you want: ");
            int choose = 0;
            try {
                 choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong format");
            }

            switch (choose) {
                case 1:
                    iEmployeeService.employeeMenu();
                    break;
                case 6:
                    check = false;
                    break;
                default:
                    System.out.println("your choose is not exist");
                    break;
            }
        }

    }
}
