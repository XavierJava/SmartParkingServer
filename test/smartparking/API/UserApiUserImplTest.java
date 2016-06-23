package smartparking.API;

import org.junit.Before;
import org.junit.Test;
import smartparking.API.m.UserImpl;
import smartparking.model.User;

import java.io.IOException;

public class UserApiUserImplTest {
    private UserImpl clientImpl = new UserImpl();
    private User user = new User();

    @Before
    public void setUp() throws Exception {
        user.setName("huanhuan3");
        user.setPassword("123");
    }

    @Test
    public void testGetUsers() {
        assert clientImpl.getUsers().size() > 6;
    }

    @Test
    public void testAddUser() {
        assert clientImpl.addUser(user) > 0;
    }

    @Test
    public void testGetUserById() throws IOException {
        User user = clientImpl.getUserById(3);
        assert user != null;
    }

    @Test
    public void testGetUserByName() {
        User user = clientImpl.getUserByName("huanhuan1");
        assert user != null;
    }

    @Test
    public void testUpdateUser() throws IOException {
        User user = clientImpl.getUserById(3);
        user.setName("nan");
        assert clientImpl.updateUser(user) > 0;
    }

    @Test
    public void testRemoveUserById() throws IOException {
        assert clientImpl.removeUserById(9) > 0;
    }
}
