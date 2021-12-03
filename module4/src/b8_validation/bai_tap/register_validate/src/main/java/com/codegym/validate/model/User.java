package com.codegym.validate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @NotEmpty(message = "{email.empty}")
    @Email(message = "{email.match}")
    @Column(columnDefinition = "varchar(50)")
    private String email;

    @NotEmpty(message = "{password.empty}")
    @Size(min = 5, max = 45, message = "{password.match}")
    @Column(name = "`password`")
    private String password;

    @NotBlank(message = "{firstName.empty}")
    @Size(min = 5, max = 45, message = "{firstName.match}")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "{lastName.empty}")
    @Size(min = 5, max = 45, message = "{lastName.match}")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "{phoneNumber.empty}")
    @Pattern(regexp = "(^$|[0-9]*$)", message = "{phoneNumber.match}")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Min(value = 18, message = "{age}")
    private int age;

    public User() {
    }

    public User(@Email String email, @NotEmpty @Size(min = 5, max = 45) String password, @NotBlank @Size(min = 5, max = 45) String firstName, @NotBlank @Size(min = 5, max = 45) String lastName, String phoneNumber, @Min(18) int age) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
