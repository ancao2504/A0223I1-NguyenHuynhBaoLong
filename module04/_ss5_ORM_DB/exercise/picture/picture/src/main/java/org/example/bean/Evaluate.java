package org.example.bean;

import javax.persistence.*;

@Entity
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluate_id") // Specify the column name
    private int evaluateId;
    @ManyToOne
    @JoinColumn(name = "rank_id", referencedColumnName = "rank_id")
    private AppRank appRank;
    private String author;
    private String feedBack;

    private int countLike;

    public Evaluate() {
    }

    public Evaluate(int evaluateId, AppRank appRank, String author, String feedBack, int like) {
        this.evaluateId = evaluateId;
        this.appRank = appRank;
        this.author = author;
        this.feedBack = feedBack;
        this.countLike = like;
    }

    public int getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public AppRank getAppRank() {
        return appRank;
    }

    public void setAppRank(AppRank appRank) {
        this.appRank = appRank;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }
}
