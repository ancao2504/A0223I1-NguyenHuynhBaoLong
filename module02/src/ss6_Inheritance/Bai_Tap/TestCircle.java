package ss6_Inheritance.Bai_Tap;

public class TestCircle {
    public static void main(String[] args) {
        Circle cylinder = new Circle();
        System.out.println(cylinder);

        Cylinder cylinder1 = new Cylinder(5.0);
        System.out.println(cylinder1);

        Cylinder cylinder2 = new Cylinder(6.0, 9.0, "blue");
        System.out.println(cylinder2);
    }
}
