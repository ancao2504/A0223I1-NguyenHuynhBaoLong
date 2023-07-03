package ss8_clean_code_refactoring.practise.Refactoring_method;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = area(radius);
        double perimeter = perimeter(radius, 2, Math.PI);
        double volume = getVolume(height, baseArea, perimeter);
        return volume;
    }

    private static double getVolume(int height, double baseArea, double perimeter) {
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double perimeter(int radius, double i, double pi) {
        return i * pi * radius;
    }

    private static double area(int radius) {
        double baseArea = Math.PI * radius * radius;
        return baseArea;
    }
}
