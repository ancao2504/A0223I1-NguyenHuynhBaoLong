package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 45, message = "Name has min 3 characters and max 45")
    @Pattern(regexp = "^(?!\\s*$)[\\p{L} .'-]+$", message = "Name just has characters")
    private String name;

    @Size(min = 12, max = 12, message = "ID Card has 12 number")
    private String IDCard;

    @Size(min = 10, max = 10, message = "phone number has 10 numbers")
    private String phone;


    @OneToMany(mappedBy = "customer")
    List<DetailBorrow> detailBorrows;

    public Customer() {
    }

    public Customer( String name, String IDCard, String phone, List<DetailBorrow> detailBorrows) {
        this.name = name;
        this.IDCard = IDCard;
        this.phone = phone;
        this.detailBorrows = detailBorrows;
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

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<DetailBorrow> getDetailBorrows() {
        return detailBorrows;
    }

    public void setDetailBorrows(List<DetailBorrow> detailBorrows) {
        this.detailBorrows = detailBorrows;
    }

}
