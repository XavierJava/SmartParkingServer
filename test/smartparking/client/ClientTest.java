package smartparking.client;

import org.junit.Before;
import org.junit.Test;
import smartparking.api.Client;
import smartparking.model.User;

import java.io.IOException;

public class ClientTest {
    private Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client();
    }

    @Test
    public void testAddUser() {
        String name = "huanhuan";
        String password = "123";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        int newUserId = client.addUser(user);

        User user1 = client.getUserById(newUserId);

        assert user1.getName().equals(name);
        assert user1.getPassword().equals(password);
    }

    @Test
    public void testGetUser() throws IOException {
        User user = client.getUserById(3);
        assert user != null;
    }
}
