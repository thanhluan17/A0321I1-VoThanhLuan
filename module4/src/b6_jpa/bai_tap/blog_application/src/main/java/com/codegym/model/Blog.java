package com.codegym.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String content;
    @Column(name = "create_date")
    private String createDate;

    public Blog() {
    }

    public Blog(String title, String author, String content, String createDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createDate = createDate;
    }

    public Blog(Integer id, String title, String author, String content, String createDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
