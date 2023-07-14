package ss12_Map_Tree.exercise.model;

public class Product implements Comparable<Product> {
    private String name;
    private double cost;
    private int id;

    public Product() {
    }

    public Product(String name, double cost, int id) {
        this.name = name;
        this.cost = cost;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tên= " + name + "\n" +
                "Giá= " + cost + "" +
                "\n id= " + id + "\n";
    }

    @Override
    public int compareTo(Product o) {
        if (this.getCost() > o.getCost()) {
            return 1;
        }
        return -1;
    }

}
