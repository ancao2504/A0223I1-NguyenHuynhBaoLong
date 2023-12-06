package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "updateQuantity",
                query = "update Book b set b.quantity = :quantity where b.name= :name"
        )
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "Name has min 2 characters")
    @Pattern(regexp = "^(?!\\s*$)[\\p{L} .'-]+$", message = "Name just has characters")
    private String name;
    @Min(0)
    private int quantity;

    @OneToMany(mappedBy = "book")
    private List<DetailBorrow> detailBorrows;

    public Book() {
    }

    public Book(String name, int quantity, List<DetailBorrow> detailBorrows) {
        this.name = name;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<DetailBorrow> getDetailBorrows() {
        return detailBorrows;
    }

    public void setDetailBorrows(List<DetailBorrow> detailBorrows) {
        this.detailBorrows = detailBorrows;
    }
}
