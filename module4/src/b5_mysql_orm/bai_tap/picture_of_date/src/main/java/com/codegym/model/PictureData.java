package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class PictureData implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int point;
    private String author;
    private String feedback;

    @Column(name="_like")
    private int like;

    @Column(name="_date")
    private String date;

    public PictureData() {
    }

    public PictureData(int point, String author, String feedback, int like, String date) {
        this.point = point;
        this.author = author;
        this.feedback = feedback;
        this.like = like;
        this.date = date;
    }

    public PictureData(Long id, int point, String author, String feedback, int like, String date) {
        this.id = id;
        this.point = point;
        this.author = author;
        this.feedback = feedback;
        this.like = like;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public PictureData clone() {
        PictureData pictureData = new PictureData();
        pictureData.setId(id);
        pictureData.setPoint(point);
        pictureData.setAuthor(author);
        pictureData.setFeedback(feedback);
        pictureData.setLike(like);
        pictureData.setDate(date);
        return pictureData;
    }

    @Override
    public String toString() {
        return "PictureData{" +
                "id=" + id +
                ", point=" + point +
                ", author='" + author + '\'' +
                ", feedback='" + feedback + '\'' +
                ", like=" + like +
                ", date='" + date + '\'' +
                '}';
    }
}
