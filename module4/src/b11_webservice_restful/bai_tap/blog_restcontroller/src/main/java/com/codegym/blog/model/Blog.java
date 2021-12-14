package com.codegym.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity

@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    private String title;
    private String author;
    private String content;
    @Column(columnDefinition = "date", name = "create_date")
    private String createDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cateId")
    private Category category;

    public Blog() {
    }

    public Blog(String title, String author, String content, String createDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createDate = createDate;
    }

    public Blog(String title, String author, String content, String createDate, Category category) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createDate = createDate;
        this.category = category;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
