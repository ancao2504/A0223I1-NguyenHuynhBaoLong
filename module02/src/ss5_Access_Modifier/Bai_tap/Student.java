package ss5_Access_Modifier.Bai_tap;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student () {

    }
    public String setName(String name) {
        return this.name = name;
    }
    public String setClasses ( String name) {
        return this.classes=name;
    }
}
