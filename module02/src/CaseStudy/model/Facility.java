package CaseStudy.model;

public abstract class Facility {
    private String nameOfService;
    private double area;
    private double tax;
    private int maxPeople;
    private String type;

    public Facility(String name, double area, double tax, int maxPeople, String type) {
        this.nameOfService = name;
        this.area = area;
        this.tax = tax;
        this.maxPeople = maxPeople;
        this.type = type;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
