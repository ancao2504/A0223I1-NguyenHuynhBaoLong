package CaseStudy.model;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(String serviceCode, String nameService, double areaUse, double fee, int maxPeople, String style, String freeService) {
        super(serviceCode, nameService, areaUse, fee, maxPeople, style);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return  "freeService='" + freeService +"\n"+
                "serviceCode=" + getServiceCode() + '\n' +
                "nameService=" + getNameService() + '\n' +
                "areaUse=" + getAreaUse() +'\n'+
                "fee=" + getFee() +'\n'+
                "maxPeople=" + getMaxPeople() +'\n'+
                "style='" + getStyle();
    }
}
