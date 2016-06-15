package smartparking.dao;

import smartparking.model.User;

import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-20.
 */
public interface UserDao {
    List getUsers();

    User getUserById(int userId);

    User getUserByName(String name);

    int addUser(User user);

    int editUser(User user);

    int removeUserById(int id);
}
