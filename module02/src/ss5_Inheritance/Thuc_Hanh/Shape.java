package ss5_Inheritance.Thuc_Hanh;

public class Shape {
    private String color = "Green";
    private Boolean filled = true;

    public Shape() {

    }

    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "A shape with color "
                + this.getColor()
                + " and "
                + (this.isFilled()?"filled":"not filled");
    }
}
