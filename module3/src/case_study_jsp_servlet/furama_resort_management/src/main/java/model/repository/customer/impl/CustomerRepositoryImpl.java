package model.repository.customer.impl;

import model.bean.customer.Customer;
import model.repository.BaseRepository;
import model.repository.customer.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String SELECT_ALL = "select * from customer inner join customer_type on customer.customer_type_id " +
            "= customer_type.customer_type_id;";
    private static final String INSERT_CUSTOMER = "insert into customer " +
            "(customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) " +
            "values (?,?,?,?,?,?,?,?);";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?, " +
            "customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?;";
    private static final String FIND_BY_ID = "select * from customer where customer_id = ?;";
    private static final String SELECT_BY_CONTAIN_NAME = "select * from customer inner join customer_type on customer.customer_type_id " +
            "= customer_type.customer_type_id where customer_name like ?;";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    int typeId = resultSet.getInt("customer_type_id");
                    String typeName = resultSet.getString("customer_type_name");
                    String name = resultSet.getString("customer_name");
                    String birthday = resultSet.getString("customer_birthday");
                    boolean gender = resultSet.getBoolean("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    customerList.add(new Customer(id, typeId, typeName, name, birthday, gender, idCard, phone, email, address));
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
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
                preparedStatement.setInt(1, customer.getTypeId());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getBirthday());
                preparedStatement.setBoolean(4, customer.isGender());
                preparedStatement.setString(5, customer.getCardID());
                preparedStatement.setString(6, customer.getPhone());
                preparedStatement.setString(7, customer.getEmail());
                preparedStatement.setString(8, customer.getAddress());
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
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
                preparedStatement.setInt(1, id);
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
    public void update(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
                preparedStatement.setInt(1, customer.getTypeId());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getBirthday());
                preparedStatement.setBoolean(4, customer.isGender());
                preparedStatement.setString(5, customer.getCardID());
                preparedStatement.setString(6, customer.getPhone());
                preparedStatement.setString(7, customer.getEmail());
                preparedStatement.setString(8, customer.getAddress());
                preparedStatement.setInt(9, customer.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    customer = new Customer();
                    customer.setId(resultSet.getInt("customer_id"));
                    customer.setTypeId(resultSet.getInt("customer_type_id"));
                    customer.setName(resultSet.getString("customer_name"));
                    customer.setBirthday(resultSet.getString("customer_birthday"));
                    customer.setGender(resultSet.getBoolean("customer_gender"));
                    customer.setCardID(resultSet.getString("customer_id_card"));
                    customer.setPhone(resultSet.getString("customer_phone"));
                    customer.setEmail(resultSet.getString("customer_email"));
                    customer.setAddress(resultSet.getString("customer_address"));
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
        return customer;
    }

    @Override
    public Customer findByName(String name) {
        return null;
    }

    @Override
    public List<Customer> findByContainName(String key) {
        Connection connection = BaseRepository.getConnection();
        List<Customer> customerList = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CONTAIN_NAME);
                preparedStatement.setString(1, "%" + key + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    int typeId = resultSet.getInt("customer_type_id");
                    String typeName = resultSet.getString("customer_type_name");
                    String name = resultSet.getString("customer_name");
                    String birthday = resultSet.getString("customer_birthday");
                    boolean gender = resultSet.getBoolean("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    customerList.add(new Customer(id, typeId, typeName, name, birthday, gender, idCard, phone, email, address));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return customerList;
    }
}
