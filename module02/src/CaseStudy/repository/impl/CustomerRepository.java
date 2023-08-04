package CaseStudy.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import CaseStudy.model.Customer;
import CaseStudy.model.Employee;
import CaseStudy.repository.ICustomerReopository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepository implements ICustomerReopository<Customer> {

    public static final String SRC_CUSTOMER = "src/CaseStudy/data/Customer.csv";

    @Override
    public void add(Customer customer) {
        ReadAndWriteFile.writeFile(SRC_CUSTOMER, convertToString(customer), true);
    }

    @Override
    public List<Customer> display() {
        List<String> stringList = ReadAndWriteFile.readFile(SRC_CUSTOMER);
        List<Customer> list = new ArrayList<>();
        String[] temp;
        for (String string : stringList) {
            temp=string.split(",");

            list.add(new Customer(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]));
        }
        return list;
    }

    @Override
    public void search(String name) {
        List<Customer> list = display();
        for (Customer customer : list) {
            if (customer.getName().equals(name)) {
                System.out.println(customer.toString());
            }
        }
    }

    @Override
    public void delete(String id) {
        List<Customer> list = display();
        for(Customer customer : list){
            if (customer.getID().equals(id)) {
                System.out.println("You sure to delete this employee get id: "+id);
                System.out.println("1. Yes");
                System.out.println("2.No");
                int choice = Integer.parseInt(new Scanner(System.in).nextLine());
                if (choice==1) {
                    list.remove(choice);
                    String line ="";
                    for (Customer customer1 : list) {
                        line+=convertToString(customer1)+"\n";
                    }
                    line = line.substring(0, line.length()-1);
                    ReadAndWriteFile.writeFile(SRC_CUSTOMER,line,false);
                    System.out.println("xóa thành công");
                }
                break;
            }
        }
    }

    private String convertToString(Customer customer) {
        return customer.getName() + "," + customer.getPhoneNumber() + "," + customer.getEmail() + "," + customer.getGender() + "," + customer.getDateOfBirth() +
                "," + customer.getID() + "," + customer.getTypeOfCustomer() + "," + customer.getAddress();
    }
}
