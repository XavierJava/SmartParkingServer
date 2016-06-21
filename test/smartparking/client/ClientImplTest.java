package smartparking.client;

import org.junit.Before;
import org.junit.Test;
import smartparking.client.impl.ClientImpl;
import smartparking.model.User;

import java.io.IOException;

public class ClientImplTest {
    private ClientImpl clientImpl;

    @Before
    public void setUp() throws Exception {
        clientImpl = new ClientImpl();
    }

    @Test
    public void testAddUser() {
        String name = "huanhuan";
        String password = "123";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        int newUserId = clientImpl.addUser(user);

        User user1 = clientImpl.getUserById(newUserId);

        assert user1.getName().equals(name);
        assert user1.getPassword().equals(password);
    }

    @Test
    public void testGetUser() throws IOException {
        User user = clientImpl.getUserById(3);
        assert user != null;
    }
}
