package com.codegym.validate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{name.empty}")
    @Size(max = 800, message = "{name.length}")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "{name.match}")
    private String name;

    @NotBlank(message = "{author.empty}")
    @Size(max = 300, message = "{author.length}")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "{author.match}")
    private String author;

    @NotBlank(message = "{cate.empty}")
    @Size(max = 1000, message = "{cate.length}")
    @Pattern(regexp = "^[A-Za-z0-9, ]*$", message = "{cate.match}")
    private String category;

    public Song() {
    }

    public Song(Integer id, @NotNull(message = "{empty}") @Size(max = 800, message = "{name.length}") @Pattern(regexp = "^[A-Za-z0-9]*$", message = "{name.match}") String name, @NotNull(message = "{empty}") @Size(max = 300, message = "{author.length}") @Pattern(regexp = "^[A-Za-z0-9]*$", message = "{author.match}") String author, @NotNull(message = "{empty}") @Size(max = 1000, message = "{cate.length}") @Pattern(regexp = "^[A-Za-z0-9,]*$", message = "{cate.match}") String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
