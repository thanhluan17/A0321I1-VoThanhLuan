package model.repository.employee;

import model.bean.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    void save(Employee employee);

    void delete(int id);

    void update(Employee employee);

    Employee findById(int id);

    Employee findByName(String name);

    List<Employee> findByContainName(String key);
}
