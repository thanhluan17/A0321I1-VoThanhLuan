package com.codegym.exam.service.impl;

import com.codegym.exam.model.Discount;
import com.codegym.exam.repository.DiscountRepository;
import com.codegym.exam.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    DiscountRepository discountRepository;

    @Override
    public Iterable<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Page<Discount> findAll(Pageable pageable) {
        return discountRepository.findAll(pageable);
    }

    @Override
    public Discount findById(Integer id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void remove(Integer id) {
        discountRepository.deleteById(id);
    }

    @Override
    public Page<Discount> findAllByDiscountAmount(double name, Pageable pageable) {
        return discountRepository.findAllByDiscountAmount(name, pageable);
    }

    @Override
    public Page<Discount> findAllByStartTime(LocalDate start, Pageable pageable) {
        return discountRepository.findAllByStartTime(start, pageable);
    }

    @Override
    public Page<Discount> findAllByEndTime(LocalDate end, Pageable pageable) {
        return discountRepository.findAllByEndTime(end, pageable);
    }

    @Override
    public Page<Discount> findAllByDiscountAmountOrStartTimeOrEndTime(double name, LocalDate start, LocalDate end, Pageable pageable) {
        return discountRepository.findAllByDiscountAmountOrStartTimeOrEndTime(name, start, end, pageable);
    }

}
