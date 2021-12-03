package com.codegym.validate.service;

import com.codegym.validate.model.User;

public interface UserService {
    Iterable<User> findAll();

    User findById(Long id);

    void save(User customer);
}
