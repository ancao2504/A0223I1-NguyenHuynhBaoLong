package com.example.case_study.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Size(max = 12, min = 12, message = "ID card has 12 numbers")
    private String idCard;
    private Double salary;
    @Pattern(regexp = "^[0-9]{10}", message = "phone has 10 numbers")
    private String phone;
    @Pattern(regexp = "/^[^.\\s@]+(\\.[^.\\s@]+)*@[^.\\s@]+(\\.[^.\\s@]+)+$/", message = "email format: xxx@xxx.xxx or xxx.xxx@xxx.xxx")
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;


    @ManyToOne
    @JoinColumn(name = "educationDegree_id")
    private EducationDegree educationDegree;
    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;
    private Boolean status;

    public Employee() {
    }

    public Employee(String name, Date birthday, String idCard, Double salary, String phone, String email, String address,
                    Division division, Position position, EducationDegree educationDegree, List<Contract> contracts, Boolean status) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.division = division;
        this.position = position;
        this.educationDegree = educationDegree;
        this.contracts = contracts;
        this.status = status;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }
}
