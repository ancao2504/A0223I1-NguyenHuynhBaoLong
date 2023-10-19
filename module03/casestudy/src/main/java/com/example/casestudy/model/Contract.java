package com.example.casestudy.model;

import java.util.Date;

public class Contract {
    private int id;
    private Date startContract;
    private Date endContract;
    private double depositContract;
    private double totalMoney;
    private int idEmployee;
    private int idCustomer;
    private int idService;

    public Contract(int id, Date startContract, Date endContract, double depositContract, double totalMoney,
                    int idEmployee, int idCustomer, int idService) {
        this.id = id;
        this.startContract = startContract;
        this.endContract = endContract;
        this.depositContract = depositContract;
        this.totalMoney = totalMoney;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public Contract(Date startContract, Date endContract, double depositContract, double totalMoney, int idEmployee,
                    int idCustomer, int idService) {
        this.startContract = startContract;
        this.endContract = endContract;
        this.depositContract = depositContract;
        this.totalMoney = totalMoney;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartContract() {
        return startContract;
    }

    public void setStartContract(Date startContract) {
        this.startContract = startContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public double getDepositContract() {
        return depositContract;
    }

    public void setDepositContract(double depositContract) {
        this.depositContract = depositContract;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }
}
