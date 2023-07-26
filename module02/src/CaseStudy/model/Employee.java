package CaseStudy.model;

public class Employee extends Person{
    private String codeEmployee;
    private String standard;
    private double salary;
    private String position;

    public Employee() {
    }

    public Employee(String name, long phoneNumber, String email, String gender, String dateOfBirth, String iD, String codeEmployee, String standard, double salary, String position) {
        super(name, phoneNumber, email, gender, dateOfBirth, iD);
        this.codeEmployee = codeEmployee;
        this.standard = standard;
        this.salary = salary;
        this.position = position;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {

        return  "name: " +this.getName()+'\n'+
                "ID:" +this.getID()+'\n'+
                "date of birth: " + this.getDateOfBirth()+"\n"+
                 "gender:  "+this.getGender()+ '\n'+
                "codeEmployee=" + this.getCodeEmployee()+ '\n' +
                "standard=" + standard + '\n' +
                "salary=" + salary +
                " position=" + position + '\n' +
                "phone number= " +this.getPhoneNumber()+"\n" +
                "email: " + this.getEmail()+ "\n" +
                "-------------------------------";
    }
}