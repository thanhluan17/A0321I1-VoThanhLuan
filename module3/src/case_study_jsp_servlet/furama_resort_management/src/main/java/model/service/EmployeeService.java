package model.service;

import model.bean.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> findAll();

    Map<String, String> create(Employee employee);
}
