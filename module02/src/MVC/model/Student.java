package MVC.model;

public class Student extends Person{
    private double grade;

    public Student() {

    }
    public Student(int code,String name,String dateOfBirth,double grade){
        super(code, name, dateOfBirth);
        this.grade=grade;
    }
    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade=grade;
    }

    public String toString () {

        return "mã số " +this.getCode() +" tên: " +this.getName()+" ngày sinh: "+this.getDateOfBirth()+" lớp "+this.getGrade();
    }
}
