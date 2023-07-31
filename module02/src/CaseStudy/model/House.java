package CaseStudy.model;

public class House extends Facility {
    private String standardRoom;
    private int floor;

    public House() {
    }

    public House(String serviceCode, String nameService, double areaUse, double fee, int maxPeople, String style, String standardRoom, int floor) {
        super(serviceCode, nameService, areaUse, fee, maxPeople, style);
        this.standardRoom = standardRoom;
        this.floor = floor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "serviceCode=" + getServiceCode() + '\n' +
                "nameService=" + getNameService() + '\n' +
                "areaUse=" + getAreaUse() + '\n' +
                "fee=" + getFee() + '\n' +
                "maxPeople=" + getMaxPeople() + '\n' +
                "style='" + getStyle() + '\n' +
                "standardRoom=" + standardRoom + '\n' +
                "floor=" + floor + '\n';
    }
}
