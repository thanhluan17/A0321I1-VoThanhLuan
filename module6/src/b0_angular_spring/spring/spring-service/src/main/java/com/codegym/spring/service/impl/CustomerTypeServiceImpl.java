package com.codegym.spring.service.impl;

import com.codegym.spring.model.CustomerType;
import com.codegym.spring.repository.CustomerTypeRepository;
import com.codegym.spring.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
