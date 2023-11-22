package com.example.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_rank")
public class AppRank {
    @Id
    @Column(name = "rank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "appRank")
    private List<Evaluate> evaluate;

    public AppRank() {
    }

    public AppRank(int rankId, String name) {
        this.id = rankId;
        this.name = name;
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

    public List<Evaluate> getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(List<Evaluate> evaluates) {
        this.evaluate = evaluates;
    }

}
