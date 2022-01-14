package com.codegym.exam.service;

import com.codegym.exam.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface DiscountService {
    Iterable<Discount> findAll();

    Page<Discount> findAll(Pageable pageable);

    Discount findById(Integer id);

    void save(Discount discount);

    void remove(Integer id);

    Page<Discount> findAllByDiscountAmount(double name, Pageable pageable);

    Page<Discount> findAllByStartTime(LocalDate start, Pageable pageable);

    Page<Discount> findAllByEndTime(LocalDate end, Pageable pageable);

    Page<Discount> findAllByDiscountAmountOrStartTimeOrEndTime(double name, LocalDate start, LocalDate end , Pageable pageable);
}
