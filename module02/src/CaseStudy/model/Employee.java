package CaseStudy.model;

public class Employee extends Person{
    private int code;
    private String level;
    private String nominee;
    public Employee() {
    }

    public Employee(String name, String dateOfBirth, String sex, long ID, int phoneNumber, String email, int code, String level, String nominee) {
        super( name, dateOfBirth, sex, ID, phoneNumber, email);
        this.code = code;
        this.level = level;
        this.nominee=nominee;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    @Override
    public String toString() {
        return super.toString() +" \n level: "+this.level+" \n mã: "+this.code+"\n vị trí: "+this.nominee +"\n";
    }
}
