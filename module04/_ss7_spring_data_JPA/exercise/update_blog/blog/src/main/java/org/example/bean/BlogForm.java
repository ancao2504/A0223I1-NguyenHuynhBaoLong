package org.example.bean;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

public class BlogForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String title;
    private Date date;
    @Column(columnDefinition = "text")
    private String description;
    private MultipartFile img;
    @PrePersist
    private void onCreate() {
        if (date == null) {
            date= new Date();
        }
    }

    public BlogForm() {
    }

    public BlogForm(String author, String title, Date date, String description, MultipartFile img) {
        this.date=date;
        this.author = author;
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
