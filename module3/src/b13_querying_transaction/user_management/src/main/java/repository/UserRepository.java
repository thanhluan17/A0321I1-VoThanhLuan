package repository;

import bean.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(int id);

    List<User> findByCountry(String country);

    void save(User user);

    void update(int id, String name, String email, String country);

    void remove(int id);

    User getUserById(int id);

    void insertUserStore(User user);

    void addUserTransaction(User user, int[] permision);

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction();
}
