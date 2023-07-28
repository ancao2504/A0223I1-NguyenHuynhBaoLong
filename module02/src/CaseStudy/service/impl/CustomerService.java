package CaseStudy.service.impl;

import CaseStudy.model.Customer;
import CaseStudy.repository.ICustomerReopository;
import CaseStudy.repository.impl.CustomerRepository;
import CaseStudy.service.ICustomerService;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private Scanner scanner = new Scanner(System.in);
    private ICustomerReopository iCustomerReopository = new CustomerRepository();
    @Override
    public void customerMenu() {
        Boolean check = true;
        while (check) {
            System.out.println("------------Customer Menu-----------");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Delete customer");
            System.out.println("4. Search by name customer");
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
                    List<Customer> list = iCustomerReopository.display();
                    for (Customer customer: list) {
                        System.out.println(customer);
                    }
                    break;
                case 2:
                    Customer customer = customerInfo();
                    iCustomerReopository.add(customer);
                    System.out.println("-------------SUCCESS--------------");
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 5:
                    check=false;
                    break;
            }
    }
}

    public void deleteCustomer() {
        System.out.print("Enter ");
    }

    public Customer customerInfo() {
        Customer customer = new Customer();
        System.out.print("Name: ");
        customer.setName(scanner.nextLine());
        System.out.print("Phone number: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.print("Email: ");
        customer.setEmail(scanner.nextLine());
        System.out.print("Gender: ");
        customer.setGender(scanner.nextLine());
        System.out.print("Date of birth: ");
        customer.setDateOfBirth(scanner.nextLine());
        System.out.print("Type of guest: ");
        customer.setTypeOfCustomer(scanner.nextLine());
        System.out.print("Address: ");
        customer.setAddress(scanner.nextLine());

        return customer;
    }
}
