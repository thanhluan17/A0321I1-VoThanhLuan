package com.codegym.exam.repository;

import com.codegym.exam.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    Page<Discount> findAllByDiscountAmount(double name, Pageable pageable);

    Page<Discount> findAllByStartTime(LocalDate start, Pageable pageable);

    Page<Discount> findAllByEndTime(LocalDate end, Pageable pageable);

    Page<Discount> findAllByDiscountAmountOrStartTimeOrEndTime(double name, LocalDate start, LocalDate end, Pageable pageable);
}
