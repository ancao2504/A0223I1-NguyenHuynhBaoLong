package CaseStudy.service.impl;

import CaseStudy.model.Facility;
import CaseStudy.model.House;
import CaseStudy.model.Villa;
import CaseStudy.repository.IFacilityRepository;
import CaseStudy.repository.impl.FacilityRepository;
import CaseStudy.service.IFacilityService;

import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static IFacilityRepository iFacilityRepository = new FacilityRepository();

    @Override
    public void facilityMenu() {
        Boolean check = true;
        while (check) {
            System.out.println("------------Facility Menu-----------");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Delete facility");
            System.out.println("5. Return main menu");
            System.out.println("------------------------------------");
            System.out.print("Your choose:  ");

            int choose = 0;
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("------------------------wrong format--------------------");
            }
            switch (choose) {
                case 1:
//                    List<Facility> list = iFacilityRepository.display();
                    break;
                case 2:
                    addNewService();
                    break;
            }
        }
    }

    public void addNewService() {
        Boolean check = true;
        while (check) {
            System.out.println("-----------------New Service-----------------");
            System.out.println("1.Add New Villa");
            System.out.println("2.Add New House");
            System.out.println("3.Add New Room");
            System.out.println("4.Back to menu");
            System.out.println("----------------------------");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Villa villa = vilaInfo();
                    iFacilityRepository.addNewService(villa);
                    System.out.println("--------------SUCCESS------------");
                    break;
                case 2:
                    Facility house = houseInfo();
                    iFacilityRepository.addNewService(house);
                    break;
            }

        }
    }

    public Facility houseInfo() {
        House house = new House();
        System.out.print("service code: ");
        house.setServiceCode(scanner.nextLine());
        System.out.print("name service: ");
        house.setNameService(scanner.nextLine());
        System.out.print("area use: " );
        house.setAreaUse(Double.parseDouble(scanner.nextLine()));
        System.out.print("fee: ");
        house.setFee(Double.parseDouble(scanner.nextLine()));
        System.out.print("max people: ");
        house.setMaxPeople(Integer.parseInt(scanner.nextLine()));
        System.out.print("style: ");
        house.setStyle(scanner.nextLine());
        System.out.print("standard room: ");
        house.setStandardRoom(scanner.nextLine());
        System.out.print("floor: ");
        house.setFloor(Integer.parseInt(scanner.nextLine()));

        return house;
    }

    public Villa vilaInfo() {
        Villa vila = new Villa();
        System.out.print("service code: ");
        vila.setServiceCode(scanner.nextLine());
        System.out.print("name service: ");
        vila.setNameService(scanner.nextLine());
        System.out.print("area use: " );
        vila.setAreaUse(Double.parseDouble(scanner.nextLine()));
        System.out.print("fee: ");
        vila.setFee(Double.parseDouble(scanner.nextLine()));
        System.out.print("max people: ");
        vila.setMaxPeople(Integer.parseInt(scanner.nextLine()));
        System.out.print("style: ");
        vila.setStyle(scanner.nextLine());
        System.out.print("standard room: ");
        vila.setStandardRoom(scanner.nextLine());
        System.out.print("area pool: ");
        vila.setAreaPool(Double.parseDouble(scanner.nextLine()));
        System.out.print("floor: ");
        vila.setFloor(Integer.parseInt(scanner.nextLine()));

        return vila;
    }
}
