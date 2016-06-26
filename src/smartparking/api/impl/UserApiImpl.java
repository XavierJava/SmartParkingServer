package smartparking.api.impl;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import smartparking.api.UserApi;
import smartparking.model.User;
import smartparking.resources.UserResource;
import smartparking.resources.UsersResource;

import java.util.List;

public class UserApiImpl implements UserApi {
    private ClientResource service = new ClientResource("http://localhost:8111");

    public UserApiImpl() {
        service.setNext(new Client(new Context(), Protocol.HTTP));
    }

    @Override
    public List<User> getUsers(int page, int count) {
        UsersResource usersResource = service.getChild("/users?p=" + page + "&c=" + count, UsersResource.class);
        return usersResource.getUsers();
    }

    @Override
    public User getUserById(int userId) {
        UserResource userResource = service.getChild("/user/" + userId + "?q=id", UserResource.class);
        return userResource.getUser();
    }

    @Override
    public User getUserByName(String name) {
        UserResource userResource = service.getChild("/user/" + name + "?q=name", UserResource.class);
        return userResource.getUser();
    }

    @Override
    public int addUser(User user) {
        UsersResource usersResource = service.getChild("/users", UsersResource.class);
        return usersResource.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        UsersResource usersResource = service.getChild("/users", UsersResource.class);
        return usersResource.updateUser(user);
    }

    @Override
    public int removeUserById(int userId) {
        UserResource userResource = service.getChild("/user/" + userId, UserResource.class);
        return userResource.removeUser();
    }
}
