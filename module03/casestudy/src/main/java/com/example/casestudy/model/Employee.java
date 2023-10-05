package com.example.casestudy.model;

import java.sql.Date;

public class Employee {
    private int id;
    private String idCard;
    private String name;
    private Date birthDay;
    private double salary;
    private String phone;
    private String email;
    private String address;
    private int idPosition;
    private int idEducationDegree;
    private int idDivision;
    private String userName;

    public Employee(int id, String idCard, String name, Date birthDay, double salary, String phone, String email,
                    String address, int idPosition, int idEducationDegree, int idDivision, String userName) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.birthDay = birthDay;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idEducationDegree = idEducationDegree;
        this.idDivision = idDivision;
        this.userName = userName;
    }

    public Employee(String idCard, String name, Date birthDay, double salary, String phone, String email, String address,
                    int idPosition, int idEducationDegree, int idDivision, String userName) {
        this.idCard = idCard;
        this.name = name;
        this.birthDay = birthDay;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idEducationDegree = idEducationDegree;
        this.idDivision = idDivision;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(int idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
