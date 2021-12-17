package com.codegym.blog.service;

import com.codegym.blog.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
