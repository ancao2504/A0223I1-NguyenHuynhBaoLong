package CaseStudy.common;

import CaseStudy.model.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result == 0) {
            return o1.getID().compareTo(o2.getID());
        }else {
            return result;
        }
    }
}
