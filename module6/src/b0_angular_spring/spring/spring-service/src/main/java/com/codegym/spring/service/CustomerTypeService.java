package com.codegym.spring.service;

import com.codegym.spring.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
}
