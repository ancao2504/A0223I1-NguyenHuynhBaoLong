package CaseStudy.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import CaseStudy.model.Customer;
import CaseStudy.model.Employee;
import CaseStudy.repository.ICustomerReopository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static CaseStudy.repository.impl.EmployeeRepository.SRC_EMPLOYEE;

public class CustomerRepository implements ICustomerReopository<Customer> {

    public static final String SRC_CUSTOMER = "src/CaseStudy/data/Customer.csv";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void add(Customer customer) {
        ReadAndWriteFile.writeFile(SRC_EMPLOYEE, convertToString(customer), true);
    }

    @Override
    public List<Customer> display() {
        List<String> stringList = ReadAndWriteFile.readFile(SRC_EMPLOYEE);
        List<Customer> list = new ArrayList<>();
        String[] temp;
        for (String string : stringList) {
            temp=string.split(",");
            if (temp.length == 8){
                list.add(new Customer(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]));
            }
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
        List<String> lines = ReadAndWriteFile.readFile(SRC_EMPLOYEE);
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            String[] temp = line.split(",");
            if (temp[5].equals(id)) {
                if (!temp[6].startsWith("N")) {
                    System.out.println("Are you sure you want to delete this employee with ID: " + id);
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        // Skip adding this line to the newLines list
                    } else {
                        newLines.add(line);
                    }
                } else {
                    newLines.add(line);
                }
            } else {
                newLines.add(line);
            }
        }
        ReadAndWriteFile.writeFile(SRC_EMPLOYEE, String.join("\n", newLines), false);
    }
//    public void delete(String id) {
//        List<Customer> list = display();
//        for(Customer customer : list){
//            if (customer.getID().equals(id)) {
//                System.out.println("You sure to delete this employee get id: "+id);
//                System.out.println("1. Yes");
//                System.out.println("2.No");
//                int choice = Integer.parseInt(new Scanner(System.in).nextLine());
//                if (choice==1) {
//                    list.remove(customer);
//                    String line ="";
//                    for (Customer customer1 : list) {
//                        line+=convertToString(customer1)+"\n";
//                    }
//                    line = line.substring(0, line.length()-1);
//                    ReadAndWriteFile.writeFile(SRC_CUSTOMER,line,false);
//                    System.out.println("xóa thành công");
//                }
//                break;
//            }
//        }
//    }

    private String convertToString(Customer customer) {
        return customer.getName() + "," + customer.getPhoneNumber() + "," + customer.getEmail() + "," + customer.getGender() + "," + customer.getDateOfBirth() +
                "," + customer.getID() + "," + customer.getTypeOfCustomer() + "," + customer.getAddress();
    }
}
