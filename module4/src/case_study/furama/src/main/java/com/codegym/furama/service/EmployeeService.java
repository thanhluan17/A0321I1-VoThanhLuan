package com.codegym.furama.service;

import com.codegym.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Iterable<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Employee findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);

    Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable);
}
