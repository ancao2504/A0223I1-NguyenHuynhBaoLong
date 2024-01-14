package com.example.case_study.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date endDate;
    @DecimalMin(value = "0.0", inclusive = false)
    private Double total;
    private String code;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceFurama serviceFurama;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetail;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Contract() {
    }

    public Contract(Date startDate, Date endDate, Double total, String code, ServiceFurama serviceFurama,
                    List<ContractDetail> contractDetail, Employee employee, Customer customer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
        this.code = code;
        this.serviceFurama = serviceFurama;
        this.contractDetail = contractDetail;
        this.employee = employee;
        this.customer = customer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ServiceFurama getServiceFurama() {
        return serviceFurama;
    }

    public void setServiceFurama(ServiceFurama serviceFurama) {
        this.serviceFurama = serviceFurama;
    }

    public List<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
