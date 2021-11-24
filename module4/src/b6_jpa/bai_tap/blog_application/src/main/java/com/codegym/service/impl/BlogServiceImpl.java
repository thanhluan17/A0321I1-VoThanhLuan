package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.remove(id);
    }
}
