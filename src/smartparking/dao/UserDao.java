package smartparking.dao;

import smartparking.model.User;

import java.util.List;

/**
 * 用户表的数据库访问对象
 */
public interface UserDao {
    List<User> getUsers(long offset, long limit);

    User getUserById(int userId);

    User getUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int removeUserById(int id);
}
