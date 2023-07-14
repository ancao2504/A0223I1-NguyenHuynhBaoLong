package CaseStudy.controller;

import CaseStudy.service.ICustomerService;
import CaseStudy.service.IEmployeeService;
import CaseStudy.service.IFacilityService;
import CaseStudy.service.impl.CustomerServiceImpl;
import CaseStudy.service.impl.EmployeeServiceImpl;
import CaseStudy.service.impl.FacilityServiceImpl;


import java.util.Scanner;

public class FuramaController {
    private static IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    private static ICustomerService iCustomerService = new CustomerServiceImpl();
    private static IFacilityService iFacilityService = new FacilityServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        Boolean check = true;
        while (check == true) {
            System.out.println("---------Main menu------------");
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");
            System.out.println("-----------------------------");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iEmployeeService.displayMenu();
                    break;
                case 2:
                   iCustomerService.displayMenu();
                    break;
                case 3:
                   iFacilityService.displayMenu();
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
