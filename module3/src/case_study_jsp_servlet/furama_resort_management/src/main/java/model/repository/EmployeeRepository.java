package model.repository;

import model.bean.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    void save(Employee employee);

    void delete(int id);

    Employee findById(int id);

    Employee findByName(String name);
}
