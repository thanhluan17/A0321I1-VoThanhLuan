package model.service.employee.impl;

import model.bean.employee.Employee;
import model.repository.employee.EmployeeRepository;
import model.repository.employee.impl.EmployeeRepositoryImpl;
import model.service.employee.EmployeeService;
import model.service.common.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Map<String, String> create(Employee employee) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validator.validateDate(employee.getBirthday()) != null
                || Validator.validateIdCard(employee.getIdCard()) != null
                || Validator.validateInteger(employee.getSalary()) != null
                || Validator.validatePhone(employee.getPhone()) != null
                || Validator.validateEmail(employee.getEmail()) != null) {
            mapMessage.put("birthday", Validator.validateDate(employee.getBirthday()));
            mapMessage.put("idCard", Validator.validateIdCard(employee.getIdCard()));
            mapMessage.put("salary", Validator.validateInteger(employee.getSalary()));
            mapMessage.put("phone", Validator.validatePhone(employee.getPhone()));
            mapMessage.put("email", Validator.validateEmail(employee.getEmail()));
        } else {
            employeeRepository.save(employee);
        }
        return mapMessage;
    }

    @Override
    public Map<String, String> edit(Employee employee) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validator.validateDate(employee.getBirthday()) != null
                || Validator.validateIdCard(employee.getIdCard()) != null
                || Validator.validateInteger(employee.getSalary()) != null
                || Validator.validatePhone(employee.getPhone()) != null
                || Validator.validateEmail(employee.getEmail()) != null) {
            mapMessage.put("birthday", Validator.validateDate(employee.getBirthday()));
            mapMessage.put("idCard", Validator.validateIdCard(employee.getIdCard()));
            mapMessage.put("salary", Validator.validateInteger(employee.getSalary()));
            mapMessage.put("phone", Validator.validatePhone(employee.getPhone()));
            mapMessage.put("email", Validator.validateEmail(employee.getEmail()));
        } else {
            employeeRepository.update(employee);
        }
        return mapMessage;
    }


    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> findByContainName(String key) {
        return employeeRepository.findByContainName(key);
    }
}
