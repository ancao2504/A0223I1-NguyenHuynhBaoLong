package com.example.casestudy.model;

public class Service {
    private int id;
    private String name;
    private int areaService;
    private double costService;
    private int maxPeople;
    private int idRentType;
    private int idTypeService;
    private String standardRoom;
    private String description;
    private double areaPool;
    private int floor;

    public Service(int id, String name, int areaService, double costService, int maxPeople, int idRentType,
                   int idTypeService, String standardRoom, String description, double areaPool, int floor) {
        this.id = id;
        this.name = name;
        this.areaService = areaService;
        this.costService = costService;
        this.maxPeople = maxPeople;
        this.idRentType = idRentType;
        this.idTypeService = idTypeService;
        this.standardRoom = standardRoom;
        this.description = description;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public Service(String name, int areaService, double costService, int maxPeople, int idRentType,
                   int idTypeService, String standardRoom, String description, double areaPool, int floor) {
        this.name = name;
        this.areaService = areaService;
        this.costService = costService;
        this.maxPeople = maxPeople;
        this.idRentType = idRentType;
        this.idTypeService = idTypeService;
        this.standardRoom = standardRoom;
        this.description = description;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAreaService() {
        return areaService;
    }

    public void setAreaService(int areaService) {
        this.areaService = areaService;
    }

    public double getCostService() {
        return costService;
    }

    public void setCostService(double costService) {
        this.costService = costService;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
