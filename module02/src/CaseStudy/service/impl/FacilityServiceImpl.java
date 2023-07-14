package CaseStudy.service.impl;


import CaseStudy.service.IFacilityService;

import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void displayMenu() {
        Boolean check =true;
        while (check) {
            System.out.println("-----------Facility menu-----------");
            System.out.println("1.Display list facility");
            System.out.println("2.Add new facility");
            System.out.println("3.Edit facility");
            System.out.println("4.Return main menu");
            System.out.println("-------------------------------------");
            int choose =0;
            switch (choose) {
                case 1:
                    break;
                case 2:
                    newFacility();
                    break;
            }
        }
    }

    public void newFacility() {
        System.out.println("---------New facility---------");
        System.out.println("1.Add new villa");
        System.out.println("2.Add new House");
        System.out.println("3.Add new Room");
        System.out.println("4.Back to menu");
        System.out.println("-------------------------------");
    }
}
