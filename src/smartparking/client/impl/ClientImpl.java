package smartparking.client.impl;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import smartparking.client.Client;
import smartparking.common.Settings;
import smartparking.model.Order;
import smartparking.model.User;
import smartparking.resources.users.UsersResource;

import java.io.IOException;
import java.util.List;

public class ClientImpl implements Client {
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserById(int userId) {
        try {
            ClientResource userResource = new ClientResource(Settings.SERVER_HOST + "/users/" + userId);

            Representation result = userResource.get();
            JacksonRepresentation jr = new JacksonRepresentation<>(result, Order.class);

            return (User) jr.getObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public int addUser(User user) {
        UsersResource usersResource = (UsersResource) new ClientResource(Settings.SERVER_HOST + "/users/");

        JacksonRepresentation<User> jr = new JacksonRepresentation<>(user);

        return usersResource.addUser(jr);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUserById(int userId) {

    }
}
