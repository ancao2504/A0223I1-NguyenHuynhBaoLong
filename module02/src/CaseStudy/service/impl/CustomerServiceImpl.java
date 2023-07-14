package CaseStudy.service.impl;

import CaseStudy.model.Customer;
import CaseStudy.repository.IRepositoryCustomer;
import CaseStudy.repository.impl.RepositoryCustomer;
import CaseStudy.service.ICustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private List<Customer> customerList =new ArrayList<>();
    private IRepositoryCustomer iRepositoryCustomer = new RepositoryCustomer();
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void displayMenu() {
        Boolean check = true;
        while (check) {
            System.out.println("-------------Customer menu----------------");
            System.out.println("1.Display list customers");
            System.out.println("2.Add new customer");
            System.out.println("3.Edit customer");
            System.out.println("4.Return main menu");
            System.out.println("---------------------------------------");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    List<Customer> employeeList = iRepositoryCustomer.display();
                    for (Customer customer : employeeList) {
                        System.out.println(customer);
                    }
                    iRepositoryCustomer.display();
                    break;
                case 2:
                    Customer customer = addCustomer();
                    iRepositoryCustomer.add(customer);
                    break;
                case 3:
                    List<Customer> list = iRepositoryCustomer.display();
                    System.out.print("Nhập tên khách hàng bạn muốn chỉnh sửa:");
                    String inputNameCheck = scanner.nextLine();
                    iRepositoryCustomer.edit(inputNameCheck);
                    break;
                case 4:
                    check = false;
                    break;
            }
        }
    }

    public Customer addCustomer() {
        Customer customer= new Customer();
        System.out.print("NHập tên");
        customer.setName(scanner.nextLine());
        System.out.print("NHập ngày sinh");
        customer.setDateOfBirth(scanner.nextLine());
        System.out.print("NHập CMND");
        customer.setID(Long.parseLong(scanner.nextLine()));
        System.out.print("NHập giới tính");
        customer.setSex(scanner.nextLine());
        System.out.print("NHập số điện thoại");
        customer.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
        System.out.print("NHập email");
        customer.setEmail(scanner.nextLine());
        System.out.print("NHập địa chỉ");
        customer.setAddress(scanner.nextLine());
        System.out.print("NHập loại khách");
        customer.setTypeOfGuest(scanner.nextLine());
        System.out.println("------------thêm mới thành công---------------");
        return customer;
    }
}
