package CaseStudy.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import CaseStudy.model.Customer;
import CaseStudy.model.Employee;
import CaseStudy.repository.ICustomerReopository;

import java.util.ArrayList;
import java.util.List;

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

    private String convertToString(Customer customer) {
        return customer.getName() + "," + customer.getPhoneNumber() + "," + customer.getEmail() + "," + customer.getGender() + "," + customer.getDateOfBirth() +
                "," + customer.getID() + "," + customer.getTypeOfCustomer() + "," + customer.getAddress();
    }
}
