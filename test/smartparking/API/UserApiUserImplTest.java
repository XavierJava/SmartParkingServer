package smartparking.API;

import org.junit.Before;
import org.junit.Test;
import smartparking.API.m.UserImpl;
import smartparking.model.User;

import java.io.IOException;

public class UserApiUserImplTest {
    private UserImpl clientImpl = new UserImpl();
    String name = "huanhuan3";
    String password = "123";

    User user = new User();

    @Before
    public void setUp() throws Exception {
        user.setName(name);
        user.setPassword(password);
    }

    @Test
    public void testAddUser() {
        int newUserId = clientImpl.addUser(user);
        assert newUserId > 0;
    }

    @Test
    public void testGetUserById() throws IOException {
        User user = clientImpl.getUserById(3);
        System.out.println("getUserById:"+user);
        assert user != null;
    }

    @Test
    public void testGetUserByName() throws IOException {
        User user = clientImpl.getUserByName("huanhuan1");
        System.out.println("getUserByName;"+user);
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
        assert clientImpl.removeUserById(8) > 0;
    }
}
