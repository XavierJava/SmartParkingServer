package smartparking.client;

import smartparking.model.User;

import java.util.List;

public interface Client {
    List<User> getUsers();

    User getUserById(int userId);

    User getUserByName(String name);

    int addUser(User user);

    void updateUser(User user);

    void removeUserById(int userId);
}
