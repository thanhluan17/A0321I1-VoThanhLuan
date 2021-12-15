package com.codegym.phone.service;

import com.codegym.phone.model.SmartPhone;

public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();

    SmartPhone findById(Integer id);

    SmartPhone save(SmartPhone phone);

    SmartPhone remove(Integer id);
}
