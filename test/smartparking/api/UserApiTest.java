package smartparking.api;

import org.junit.Before;
import org.junit.Test;
import smartparking.api.impl.UserApiImpl;
import smartparking.model.User;

import java.io.IOException;

public class UserApiTest {
    private UserApi userApi = new UserApiImpl();
    private User user = new User();

    @Before
    public void setUp() throws Exception {
        user.setName("bjut");
        user.setPassword("123");
    }

    @Test
    public void testGetUsers() {
        int page = 1;
        int count = 3;
        assert userApi.getUsers(page, count).size() > 6;
    }

    @Test
    public void testAddUser() {
        assert userApi.addUser(user) > 0;
    }

    @Test
    public void testGetUserById() throws IOException {
        User user = userApi.getUserById(3);
        assert user != null;
    }

    @Test
    public void testGetUserByName() {
        User user = userApi.getUserByName("bjut");
        assert user != null;
    }

    @Test
    public void testUpdateUser() throws IOException {
        User user = userApi.getUserById(3);
        user.setName("nan");
        assert userApi.updateUser(user) > 0;
    }

    @Test
    public void testRemoveUserById() throws IOException {
        assert userApi.removeUserById(9) > 0;
    }
}
