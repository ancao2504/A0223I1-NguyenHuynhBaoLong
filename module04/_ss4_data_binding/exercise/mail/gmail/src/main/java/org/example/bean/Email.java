package org.example.bean;

import java.util.List;

public class Email {
    private int id;
    private String[] language;
    private String[] size;
    private Boolean spamsFilter;
    private String[] sigNature;

    public Email() {
    }

    public Email(int id,String[] language, String[] size, Boolean spamsFilter, String[] sigNature) {
        this.id=id;
        this.language = language;
        this.size = size;
        this.spamsFilter = spamsFilter;
        this.sigNature = sigNature;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public String[] getSize() {
        return size;
    }

    public void setSize(String[] size) {
        this.size = size;
    }

    public Boolean getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(Boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String[] getSigNature() {
        return sigNature;
    }

    public void setSigNature(String[] sigNature) {
        this.sigNature = sigNature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


