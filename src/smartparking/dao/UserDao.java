package smartparking.dao;

import smartparking.model.User;

import java.util.List;
public interface UserDao {
    List<User> getUsers(long offset, long limit);

    User getUserById(int userId);

    User getUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int removeUserById(int id);
}
