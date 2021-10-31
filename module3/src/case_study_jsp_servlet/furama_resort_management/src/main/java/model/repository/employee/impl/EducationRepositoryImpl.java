package model.repository.employee.impl;

import model.bean.employee.Education;
import model.repository.BaseRepository;
import model.repository.employee.EducationRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EducationRepositoryImpl implements EducationRepository {
    private static final String SELECT_ALL = "select * from education_degree;";

    @Override
    public List<Education> findAll() {
        List<Education> educationList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL);
                while (resultSet.next()) {
                    int id = resultSet.getInt("education_degree_id");
                    String name = resultSet.getString("education_degree_name");
                    educationList.add(new Education(id, name));
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
        return educationList;
    }
}
