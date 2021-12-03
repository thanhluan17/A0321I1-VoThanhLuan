package com.codegym.validate.service.impl;

import com.codegym.validate.model.User;
import com.codegym.validate.repository.UserRepository;
import com.codegym.validate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User customer) {
        userRepository.save(customer);
    }
}
