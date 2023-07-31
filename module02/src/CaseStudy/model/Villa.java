package CaseStudy.model;

public class Villa extends Facility{
    private String standardRoom;
    private double areaPool;
    private int floor;

    public Villa() {
    }

    public Villa(String serviceCode, String nameService, double areaUse, double fee, int maxPeople, String style, String standardRoom, double areaPool, int floor) {
        super(serviceCode, nameService, areaUse, fee, maxPeople, style);
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return  "serviceCode=" + this.getServiceCode() + '\n' +
                "nameService=" + getNameService() + '\n' +
                "areaUse=" + getAreaUse() +'\n'+
                "fee=" + getFee() +'\n'+
                "maxPeople=" + getMaxPeople() +'\n'+
                "style='" + getStyle() + '\n'+
                "standardRoom=" + standardRoom + '\n' +
                "areaPool=" + areaPool + '\n'+
                "floor=" + floor + '\n';
    }
}
