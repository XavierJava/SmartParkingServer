package smartparking.api;

import smartparking.model.User;

import java.util.List;

public interface ServerAPI {
    List<User> getUsers();

    User getUserById(int userId);

    User getUserByName(String name);

    int addUser(User user);

    void updateUser(User user);

    void removeUserById(int userId);
}
