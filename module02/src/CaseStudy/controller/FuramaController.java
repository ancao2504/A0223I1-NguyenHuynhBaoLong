package CaseStudy.controller;

import CaseStudy.service.IEmployeeService;
import CaseStudy.service.impl.EmployeeService;


import java.util.Scanner;

public class FuramaController {
    private static IEmployeeService iEmployeeService = new EmployeeService();
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        Boolean check = true;
        while (check == true) {
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iEmployeeService.menuOfEmployees();
                    break;
                case 2:
                    System.out.println("1.Display list customers");
                    System.out.println("2.Add new customer");
                    System.out.println("3.Edit customer");
                    System.out.println("4.Return main menu");
                    break;
                case 3:
                    System.out.println("1.Display list facility");
                    System.out.println("2.Add new facility");
                    System.out.println("3.Edit facility");
                    System.out.println("4.Return main menu");
                    break;
                case 4:
                    System.out.println("1.Add new booking");
                    System.out.println("2.Display list booking");
                    System.out.println("3.Creat new contracts");
                    System.out.println("4.Display list contracts");
                    System.out.println("5.Edit contracts");
                    System.out.println("6.Return main menu");
                    break;
                case 5:
                    System.out.println("1.Display list customers use service");
                    System.out.println("2.Display list customers get voucher");
                    System.out.println("3.Return main menu");
                    break;
                case 6:
                    check=false;
                    break;
            }
        }
    }
}
