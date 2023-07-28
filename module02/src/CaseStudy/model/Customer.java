package CaseStudy.model;

public class Customer extends Person {
    private String typeOfCustomer;
    private String address;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String email, String gender, String dateOfBirth, String iD, String typeOfCustomer, String address) {
        super(name, phoneNumber, email, gender, dateOfBirth, iD);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "name= " + this.getName() + '\n' +
                "phoneNumber= " + this.getPhoneNumber() + '\n' +
                "email='" + this.getEmail() + '\n' +
                "gender='" + this.getGender() + '\n' +
                "dateOfBirth='" + this.getDateOfBirth() + '\n' +
                "ID='" + this.getID() + '\n' +
                "typeOfCustomer=" + typeOfCustomer + '\n' +
                "address=" + address + '\n' ;
    }
}
