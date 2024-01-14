package com.example.case_study.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double rentCost;
    @OneToMany(mappedBy = "rentType")
    List<ServiceFurama> serviceFuramas;

    public RentType() {
    }

    public RentType(String name, Double rentCost, List<ServiceFurama> serviceFuramas) {
        this.name = name;
        this.rentCost = rentCost;
        this.serviceFuramas = serviceFuramas;
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

    public Double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Double rentCost) {
        this.rentCost = rentCost;
    }

    public List<ServiceFurama> getServiceFuramas() {
        return serviceFuramas;
    }

    public void setServiceFuramas(List<ServiceFurama> serviceFuramas) {
        this.serviceFuramas = serviceFuramas;
    }
}
