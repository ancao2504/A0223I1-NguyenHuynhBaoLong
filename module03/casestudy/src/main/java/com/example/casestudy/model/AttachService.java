package com.example.casestudy.model;

public class AttachService {
    private int id;
    private String name;
    private double costAttachService;
    private int unitAttachService;
    private String status;

    public AttachService(int id, String name, double costAttachService, int unitAttachService, String status) {
        this.id = id;
        this.name = name;
        this.costAttachService = costAttachService;
        this.unitAttachService = unitAttachService;
        this.status = status;
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

    public double getCostAttachService() {
        return costAttachService;
    }

    public void setCostAttachService(double costAttachService) {
        this.costAttachService = costAttachService;
    }

    public int getUnitAttachService() {
        return unitAttachService;
    }

    public void setUnitAttachService(int unitAttachService) {
        this.unitAttachService = unitAttachService;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
