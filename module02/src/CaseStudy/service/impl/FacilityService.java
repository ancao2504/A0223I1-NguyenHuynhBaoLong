package CaseStudy.service.impl;

import CaseStudy.Exception.NameServiceException;
import CaseStudy.Exception.ServiceCodeException;
import CaseStudy.model.Facility;
import CaseStudy.model.House;
import CaseStudy.model.Room;
import CaseStudy.model.Villa;
import CaseStudy.repository.IFacilityRepository;
import CaseStudy.repository.impl.FacilityRepository;
import CaseStudy.service.IFacilityService;

import java.util.List;
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
                    List<Facility> list = iFacilityRepository.display();
                    for (Facility facility : list) {
                        System.out.println(facility);
                    }
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
                    break;
                case 2:
                    House house = (House) houseInfo();
                    iFacilityRepository.addNewService(house);
                    break;
                case 3:
                    Room room = roomInfo();
                    iFacilityRepository.addNewService(room);
                    break;
                case 4:
                    check = false;
                    break;
            }
        }
    }

    public Room roomInfo() {
        Room room = new Room();
        Boolean check = true;
        do {
            System.out.print("service code: ");
            String code = scanner.nextLine();
            check = ServiceCodeException.checkCode(code);
            room.setServiceCode(code);
        } while (check == false);
        do {
            System.out.print("name service: ");
            String name = (scanner.nextLine());
            check = NameServiceException.checkNameService(name);
            room.setNameService(name);
        } while (check == false);
        double areaPool;
        do {
            System.out.print("area use: ");
            areaPool = Double.parseDouble(scanner.nextLine());
            room.setAreaUse(areaPool);
        } while (areaPool < 30);
        double fee;
        do {
            System.out.print("fee: ");
            fee = Double.parseDouble(scanner.nextLine());
            room.setFee(fee);
        } while (fee <= 0);
        int maxPeople;
        do {
            System.out.print("max people: ");
            maxPeople = (Integer.parseInt(scanner.nextLine()));
            room.setMaxPeople(maxPeople);
        } while (maxPeople < 0 || maxPeople > 20);
        System.out.print("style: ");
        room.setStyle(scanner.nextLine());
        System.out.print("free service: ");
        room.setFreeService(scanner.nextLine());

        return room;
    }

    public Facility houseInfo() {
        House house = new House();
        Boolean check = true;
        do {
            System.out.print("service code: ");
            String code = scanner.nextLine();
            check = ServiceCodeException.checkCode(code);
            house.setServiceCode(code);
        } while (check == false);
        do {
            System.out.print("name service: ");
            String name = (scanner.nextLine());
            check = NameServiceException.checkNameService(name);
            house.setNameService(name);
        } while (check == false);
        double areaPool;
        do {
            System.out.print("area use: ");
            areaPool = Double.parseDouble(scanner.nextLine());
            house.setAreaUse(areaPool);
        } while (areaPool < 30);
        double fee;
        do {
            System.out.print("fee: ");
            fee = Double.parseDouble(scanner.nextLine());
            house.setFee(fee);
        } while (fee <= 0);
        int maxPeople;
        do {
            System.out.print("max people: ");
            maxPeople = (Integer.parseInt(scanner.nextLine()));
            house.setMaxPeople(maxPeople);
        } while (maxPeople < 0 || maxPeople > 20);
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
        Boolean check = true;
        do {
            System.out.print("service code: ");
            String code = scanner.nextLine();
            check = ServiceCodeException.checkCode(code);
            vila.setServiceCode(code);
        } while (check == false);
        do {
            System.out.print("name service: ");
            String name = (scanner.nextLine());
            check = NameServiceException.checkNameService(name);
            vila.setNameService(name);
        } while (check == false);
        double areaPool;
        do {
            System.out.print("area use: ");
            areaPool = Double.parseDouble(scanner.nextLine());
            vila.setAreaUse(areaPool);
        } while (areaPool < 30);
        double fee;
        do {
            System.out.print("fee: ");
            fee = Double.parseDouble(scanner.nextLine());
            vila.setFee(fee);
        } while (fee <= 0);
        int maxPeople;
        do {
            System.out.print("max people: ");
            maxPeople = (Integer.parseInt(scanner.nextLine()));
            vila.setMaxPeople(maxPeople);
        } while (maxPeople < 0 || maxPeople > 20);
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
