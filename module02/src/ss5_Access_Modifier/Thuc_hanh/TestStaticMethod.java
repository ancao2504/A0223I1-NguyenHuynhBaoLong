package ss5_Access_Modifier.Thuc_hanh;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student student1 = new Student(111,"Long");
        Student student2 = new Student(222,"Bảo");
        Student student3 = new Student(333,"Đào");
        student1.display();
        student2.display();
        student3.display();
    }
}
