package org.example.bean;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {

    private String name;
    private String author;
    private String category;
    private MultipartFile link;

    public MusicForm() {
    }

    public MusicForm( String name, String author, String category, MultipartFile link) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.link = link;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }
}
