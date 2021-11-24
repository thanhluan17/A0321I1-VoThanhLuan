package com.codegym.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T model);

    void remove(Integer id);
}
