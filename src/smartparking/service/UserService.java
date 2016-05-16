package smartparking.service;

import smartparking.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getUsers() throws SQLException;

    User getUserById(int id) throws SQLException;

    User getUserByName(String name) throws SQLException;

    void addUser(User user) throws SQLException;

    void editUser(User user) throws SQLException;

    void removeUserById(int id) throws SQLException;
}
