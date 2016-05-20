package smartparking.dao;

import smartparking.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-20.
 */
public interface UserDao {
    //return all users
    List getUsers() throws SQLException;

    User getUserById(int userid) throws SQLException;

    User getUserByName(String name) throws SQLException;

    boolean addUser(User user) throws SQLException;

    void editUser(User user) throws SQLException;

    void removeUserById(int id) throws SQLException;
}
