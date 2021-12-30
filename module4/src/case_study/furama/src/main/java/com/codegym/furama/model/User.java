package com.codegym.furama.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(columnDefinition = "varchar(50)", nullable = false)
    @NotEmpty
    private String username;

    @Column(name = "`password`", nullable = false)
    @NotEmpty
    private String password;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
