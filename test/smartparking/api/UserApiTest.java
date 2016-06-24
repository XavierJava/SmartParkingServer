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
        user.setName("huanhuan3");
        user.setPassword("123");
    }

    @Test
    public void testGetUsers() {
        assert userApi.getUsers().size() > 6;
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
        User user = userApi.getUserByName("huanhuan1");
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
