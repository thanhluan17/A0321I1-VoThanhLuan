package model.repository.impl;

import model.bean.BenhNhan;
import model.repository.BaseRepository;
import model.repository.BenhNhanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepositoryImpl implements BenhNhanRepository {
    private static final String SELECT_ALL = "select * from benh_nhan;";

    @Override
    public List<BenhNhan> findAll() {
        List<BenhNhan> benhNhanList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int ma_benh_nhan = resultSet.getInt("ma_benh_nhan");
                    String ten_benh_nhan = resultSet.getString("ten_benh_nhan");
                    benhNhanList.add(new BenhNhan(ma_benh_nhan, ten_benh_nhan));
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
        return benhNhanList;
    }
}
