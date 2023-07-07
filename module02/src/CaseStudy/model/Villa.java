package CaseStudy.model;

public class Villa extends Facility {
    private String roomStandard;
    private double areaOfPool;
    private int floor;

    public Villa(String name, double area, double tax, int maxPeople, String type, String roomStandard, double areaOfPool, int floor) {
        super(name, area, tax, maxPeople, type);
        this.roomStandard = roomStandard;
        this.areaOfPool = areaOfPool;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(double areaOfPool) {
        this.areaOfPool = areaOfPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
