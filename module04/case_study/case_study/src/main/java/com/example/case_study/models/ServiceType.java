package com.example.case_study.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "serviceType")
    private List<ServiceFurama> serviceFuramas;

    public ServiceType() {
    }

    public ServiceType(String name, List<ServiceFurama> serviceFuramas) {
        this.name = name;
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

    public List<ServiceFurama> getServiceFuramas() {
        return serviceFuramas;
    }

    public void setServiceFuramas(List<ServiceFurama> serviceFuramas) {
        this.serviceFuramas = serviceFuramas;
    }
}
