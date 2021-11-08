package model.repository.impl;

import model.bean.BenhAn;
import model.repository.BaseRepository;
import model.repository.BenhAnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepositoryImpl implements BenhAnRepository {
    private static final String SELECT_ALL = "select * from benh_an inner join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.ma_benh_nhan;";
    private static final String INSERT_BA = "insert into benh_an (ma_benh_nhan, ngay_nhap_vien, ngay_ra_vien, ly_do) values(?, ?, ?, ?);";
    private static final String DELETE_BA = "delete from benh_an where ma_benh_an = ?;";
    private static final String FIND_BY_ID = "select * from benh_an inner join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.ma_benh_nhan where ma_benh_an = ?;";
    private static final String UPDATE_BA = "update benh_an set ma_benh_nhan = ?, ngay_nhap_vien = ?, ngay_ra_vien = ?, ly_do = ? where ma_benh_an = ?;";

    @Override
    public List<BenhAn> findAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int ma_benh_an = resultSet.getInt("ma_benh_an");
                    int ma_benh_nhan = resultSet.getInt("ma_benh_nhan");
                    String ten_benh_nhan = resultSet.getString("ten_benh_nhan");
                    String ngay_nhap_vien = resultSet.getString("ngay_nhap_vien");
                    String ngay_ra_vien = resultSet.getString("ngay_ra_vien");
                    String ly_do = resultSet.getString("ly_do");
                    benhAnList.add(new BenhAn(ma_benh_an, ma_benh_nhan, ten_benh_nhan, ngay_nhap_vien, ngay_ra_vien, ly_do));
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
        return benhAnList;
    }

    @Override
    public void save(BenhAn benhAn) {
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BA);
                preparedStatement.setInt(1, benhAn.getMa_benh_nhan());
                preparedStatement.setString(2, benhAn.getNgay_nhap_vien());
                preparedStatement.setString(3, benhAn.getNgay_ra_vien());
                preparedStatement.setString(4, benhAn.getLy_do());
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
    public int delete(int ma_benh_an) {
        Connection connection = BaseRepository.getConnection();
        int row = 0;
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BA);
                preparedStatement.setInt(1, ma_benh_an);
                row = preparedStatement.executeUpdate();
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
        return row;
    }

    @Override
    public void update(BenhAn benhAn) {
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BA);
                preparedStatement.setInt(1, benhAn.getMa_benh_nhan());
                preparedStatement.setString(2, benhAn.getNgay_nhap_vien());
                preparedStatement.setString(3, benhAn.getNgay_ra_vien());
                preparedStatement.setString(4, benhAn.getLy_do());
                preparedStatement.setInt(5, benhAn.getMa_benh_an());
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
    public BenhAn findById(int ma_benh_an) {
        Connection connection = BaseRepository.getConnection();
        BenhAn benhAn = null;
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
                preparedStatement.setInt(1, ma_benh_an);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    benhAn = new BenhAn();
                    benhAn.setMa_benh_an(resultSet.getInt("ma_benh_an"));
                    benhAn.setMa_benh_nhan(resultSet.getInt("ma_benh_nhan"));
                    benhAn.setNgay_nhap_vien(resultSet.getString("ngay_nhap_vien"));
                    benhAn.setNgay_ra_vien(resultSet.getString("ngay_ra_vien"));
                    benhAn.setLy_do(resultSet.getString("ly_do"));
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
        return benhAn;
    }
}
