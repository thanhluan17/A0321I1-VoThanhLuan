package com.codegym.spring.model;

import com.codegym.spring.validation.Birthday;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @NotBlank(message = "name must be not empty!")
    @Column(name = "customer_name")
    private String customerName;

    @Birthday(message = "age must be more than 18!")
    @Column(name = "customer_birthday")
    private String customerBirthday;

    @Column(name = "customer_gender")
    private boolean customerGender;

    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "id card length must be 9 or 12 number!")
    @Column(name = "customer_id_card")
    private String customerIdCard;

    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\(\\+84\\)90)\\d{7}$)|(^(\\(\\+84\\)91)\\d{7}$)", message = "invalid phone number!")
    @Column(name = "customer_phone")
    private String customerPhone;

    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "invalid email format (abc123@gmail.com)!")
    @Column(name = "customer_email")
    private String customerEmail;

    @NotBlank(message = "address must be not empty!")
    @Column(name = "customer_address")
    private String customerAddress;

    public Customer() {
    }

    public Customer(CustomerType customerType, @NotBlank(message = "name must be not empty!") String customerName, String customerBirthday, boolean customerGender, @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "id card length must be 9 or 12 number!") String customerIdCard, @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\(\\+84\\)90)\\d{7}$)|(^(\\(\\+84\\)91)\\d{7}$)", message = "invalid phone number!") String customerPhone, @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "invalid email format (abc123@gmail.com)!") String customerEmail, @NotBlank(message = "address must be not empty!") String customerAddress) {
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Customer(Integer customerId, CustomerType customerType, @NotBlank(message = "name must be not empty!") String customerName, String customerBirthday, boolean customerGender, @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "id card length must be 9 or 12 number!") String customerIdCard, @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\(\\+84\\)90)\\d{7}$)|(^(\\(\\+84\\)91)\\d{7}$)", message = "invalid phone number!") String customerPhone, @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "invalid email format (abc123@gmail.com)!") String customerEmail, @NotBlank(message = "address must be not empty!") String customerAddress) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
