package ss5_Access_Modifier.Thuc_hanh;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;

    public Car (String n, String e){
        name = n;
        engine = e;
        numberOfCars++;
    }
}
