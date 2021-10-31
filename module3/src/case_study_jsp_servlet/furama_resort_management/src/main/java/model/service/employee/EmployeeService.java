package model.service.employee;

import model.bean.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Map<String, String> create(Employee employee);

    Map<String, String> edit(Employee employee);

    void delete(int id);

    List<Employee> findByContainName(String key);
}
