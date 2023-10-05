package com.example.casestudy.model;

public class RentType {
    private int id;
    private String name;
    private double costRent;

    public RentType(int id, String name, double costRent) {
        this.id = id;
        this.name = name;
        this.costRent = costRent;
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

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }
}
