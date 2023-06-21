package ss5_Access_Modifier.Thuc_hanh;

public class Student {
    private int rollno;
    private String name;
    private static String collage = "BBDIT";

    public Student (int r,String n) {
        rollno = r;
        name = n;
    }
    static void change() {
        collage = "CodeGym";
    }
    void display () {
        System.out.println(rollno+ " " + name +" " +collage);
    }
}
