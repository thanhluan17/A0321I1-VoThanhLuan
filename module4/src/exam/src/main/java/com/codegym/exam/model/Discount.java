package com.codegym.exam.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Integer discountId;

    @NotBlank(message = "must be not empty!")
    private String title;

    @NotNull(message = "must be not empty!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future(message = "time must greater than current time")
    @Column(name = "start_time")
    private LocalDate startTime;

    @NotNull(message = "must be not empty!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "end_time")
    private LocalDate endTime;

    @Min(10000)
    @Column(name = "dicount_amount")
    private double discountAmount;

    @NotBlank(message = "must be not empty!")
    private String detail;

    public Discount() {
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
