package CaseStudy.repository.impl;

import CaseStudy.model.Customer;
import CaseStudy.model.Employee;
import CaseStudy.repository.IRepositoryCustomer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RepositoryCustomer implements IRepositoryCustomer {
    private static final List<Customer> listCustomer = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);
    static {
        listCustomer.add(new Customer("long","12/12/12","nam",12,123124234,"asdasd@","Ádas","ádasd"));
        listCustomer.add(new Customer("ád","12/sd12/12","nam",12,123124234,"asdasd@","Ádas","ádasd"));
        listCustomer.add(new Customer("ád","12/12/12","nam",12,123124234,"asdasd@","Ádas","ádasd"));
    }
    @Override
    public void add(Customer customer) {
        listCustomer.add(customer);
    }

    @Override
    public List<Customer> display() {
        return listCustomer;
    }



    @Override
    public void edit(String inputNameCheck) {
        for (Customer customer: listCustomer) {
            if (inputNameCheck.equals(customer.getName())) {
                System.out.println(customer.toString());
                System.out.println("bạn muốn thay đổi thông tin nào:");
                System.out.println("1.Tên");
                System.out.println("2.Số điện thoại");
                System.out.println("3.Email");
                System.out.println("4.Giới tính");
                System.out.println("5.Ngày sinh");
                System.out.println("6.CCCD");
                System.out.println("7.loại khách");
                System.out.println("8.địa chỉ");
                System.out.println("0.thoát");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.print("Nhập tên mới:");
                        String name = scanner.nextLine();
                        customer.setName(name);
                        break;
                    case 2:
                        System.out.print("Nhập SĐT mới:");
                        int phone = Integer.parseInt(scanner.nextLine());
                        customer.setPhoneNumber(phone);
                        break;
                    case 3:
                        System.out.print("Nhập Email mới:");
                        String email = scanner.nextLine();
                        customer.setEmail(email);
                        break;
                    case 4:
                        System.out.print("Nhập giới tính:");
                        String sex = scanner.nextLine();
                        customer.setSex(sex);
                        break;
                    case 5:
                        System.out.print("Nhập ngày sinh:");
                        String dateOfBirth = scanner.nextLine();
                        customer.setDateOfBirth(dateOfBirth);
                        break;
                    case 6:
                        System.out.print("Nhập CCCD:");
                        long ID = Long.parseLong(scanner.nextLine());
                        customer.setID(ID);
                        break;
                    case 7:
                        System.out.print("Nhập loại khách:");
                        String typeOfGuest = (scanner.nextLine());
                        customer.setTypeOfGuest(typeOfGuest);
                        break;
                    case 8:
                        System.out.print("Nhập địa chỉ:");
                        String address = scanner.nextLine();
                        customer.setAddress(address);
                        break;
                }
            } else {
                System.out.println("Không tìm thấy tên !!");
                break;
            }
        }
    }
}
