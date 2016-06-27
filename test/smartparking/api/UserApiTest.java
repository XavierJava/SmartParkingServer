package smartparking.api;

import org.junit.Test;
import smartparking.api.impl.UserApiImpl;
import smartparking.model.User;

import java.io.IOException;

public class UserApiTest {
    private UserApi userApi = new UserApiImpl();

    @Test
    public void testGetUserById() throws IOException {
        User user = new User();
        user.setName("a");
        user.setPassword("123");
        assert userApi.getUserById(userApi.addUser(user)).getName().equals("a");
    }

    @Test
    public void testGetUserByName() {
        User user = new User();
        user.setName("b");
        user.setPassword("123");
        userApi.addUser(user);
        assert userApi.getUserByName("b").getName().equals("b");
    }

    @Test
    public void testGetUsers() {
        User user = new User();
        user.setName("c");
        user.setPassword("123");
        userApi.addUser(user);
        userApi.addUser(user);
        userApi.addUser(user);
        userApi.addUser(user);
        int page = 1;
        int count = 3;
        assert userApi.getUsers(page, count).size() == 3;
        page = 2;
        count = 4;
        assert userApi.getUsers(page, count).size() == 4;
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("d");
        user.setPassword("123");
        assert userApi.addUser(user) > 1;
    }

    @Test
    public void testUpdateUser() throws IOException {
        User user = new User();
        user.setName("e");
        user.setPassword("123");
        User u = userApi.getUserById(userApi.addUser(user));
        u.setName("nan");
        userApi.updateUser(u);
        assert userApi.getUserById(u.getId()).getName().equals("nan");
    }

    @Test
    public void testRemoveUserById() throws IOException {
        User user = new User();
        user.setName("f");
        user.setPassword("123");
        assert userApi.removeUserById(userApi.addUser(user)) == 1;
    }
}
