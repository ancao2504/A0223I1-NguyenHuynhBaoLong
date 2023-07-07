package CaseStudy.model;

public abstract class Person {
    private String name;
    private String dateOfBirth;
    private String sex;
    private long ID;
    private int phoneNumber;
    private String email;


    public Person() {
    }

    public Person(String name, String dateOfBirth, String sex, long ID, int phoneNumber, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "tên: " + this.name + "\n số điện thoại: " + this.phoneNumber + "\n CMND: " + this.ID + "\n Giới tính: " + this.sex + "\n ngày sinh: " + this.dateOfBirth + "\n Email: " + this.email ;
    }
}
