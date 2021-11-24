package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);
}
