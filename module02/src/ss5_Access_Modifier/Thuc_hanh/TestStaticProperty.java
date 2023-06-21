package ss5_Access_Modifier.Thuc_hanh;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3","Sky");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Mazda 6","ky");
        System.out.println(Car.numberOfCars);
    }
}
