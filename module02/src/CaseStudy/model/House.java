package CaseStudy.model;

public class House extends Facility {
    private String roomStandard;
    private int floor;

    public House(String name, double area, double tax, int maxPeople, String type, String roomStandard, int floor) {
        super(name, area, tax, maxPeople, type);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
