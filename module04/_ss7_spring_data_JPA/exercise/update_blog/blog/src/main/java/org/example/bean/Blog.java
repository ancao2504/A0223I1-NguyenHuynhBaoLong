package org.example.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findByTitle",
         query = "from Blog b where b.title like :title")
})
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String title;
    private String img;
    private Date date;
    @OneToMany(mappedBy = "blog")
    private List<Category> category;
    @Column(columnDefinition = "text")
    private String description;
    @PrePersist
    private void onCreate() {
        if (date == null) {
            date= new Date();
        }
    }



    public Blog() {
    }

    public Blog(String author, String title, String img, Date date, String description) {
        this.author = author;
        this.title = title;
        this.img = img;
        this.date = date;
        this.description = description;
    }

    public Blog(String author, String title, String img, String description) {
        this.author = author;
        this.title = title;
        this.img = img;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
