package smartparking.api;

import smartparking.model.User;

import java.util.List;

public interface UserApi {
    List<User> getUsers(int page, int count);

    User getUserById(int userId);

    User getUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int removeUserById(int userId);
}
