package CaseStudy.model;

public class Customer extends Person{
    private String typeOfGuest;
    private String address;

    public Customer() {
    }

    public Customer(String typeOfGuest, String address) {
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +" \n địa chỉ: "+this.address+" \n loại khách: "+this.typeOfGuest+"\n";
    }

    public Customer(String name, String dateOfBirth, String sex, int ID, int phoneNumber, String email, String typeOfGuest, String address) {
        super(name, dateOfBirth, sex, ID, phoneNumber, email);
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
