package model.repository.impl;

import model.bean.employee.Employee;
import model.repository.BaseRepository;
import model.repository.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String SELECT_ALL = "select * from employee inner join position on employee.position_id " +
            "= position.position_id inner join education_degree on employee.education_degree_id " +
            "= education_degree.education_degree_id inner join division on employee.division_id = division.division_id;";
    private static final String INSERT_EMPLOYEE = "insert into employee " +
            "(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id) " +
            "values (?,?,?,?,?,?,?,?,?,?);";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    String birthday = resultSet.getString("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int positionId = resultSet.getInt("position_id");
                    String positionName = resultSet.getString("position_name");
                    int educationId = resultSet.getInt("education_degree_id");
                    String educationName = resultSet.getString("education_degree_name");
                    int divisionId = resultSet.getInt("division_id");
                    String divisionName = resultSet.getString("division_name");
                    employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, positionName, educationId, educationName, divisionId, divisionName));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getBirthday());
                preparedStatement.setString(3, employee.getIdCard());
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.setString(5, employee.getPhone());
                preparedStatement.setString(6, employee.getEmail());
                preparedStatement.setString(7, employee.getAddress());
                preparedStatement.setInt(8, employee.getPositionId());
                preparedStatement.setInt(9, employee.getEducationId());
                preparedStatement.setInt(10, employee.getDivisionId());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public Employee findByName(String name) {
        return null;
    }
}
