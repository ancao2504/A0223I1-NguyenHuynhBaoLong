package CaseStudy.model;

public class Room extends Facility {
    private String freeService;

    public Room(String name, double area, double tax, int maxPeople, String type, String freeService) {
        super(name, area, tax, maxPeople, type);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
