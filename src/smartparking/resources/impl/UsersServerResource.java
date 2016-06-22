package smartparking.resources.impl;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.UserDao;
import smartparking.model.User;
import smartparking.resources.common.UsersResource;

import java.io.IOException;
import java.util.List;

public class UsersServerResource extends ServerResource implements UsersResource {
    UserDao userDao;

    @Override
    protected void doInit() {
        super.doInit();
        userDao = Settings.getUserDao();
    }


    @Override
    public Representation getUsers() {
        List users;
        users = userDao.getUsers();
        return users == null ? new StringRepresentation("不存在用户", MediaType.TEXT_PLAIN) :
                new JacksonRepresentation<>(users);
    }

    @Override
    public int updateUser(Representation rep) {
        JacksonRepresentation<User> userRep = new JacksonRepresentation<User>(rep, User.class);
        User user = null;
        try {
            user = userRep.getObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userDao.editUser(user);
    }

    @Override
    public int addUser(Representation rep) {
        JacksonRepresentation<User> userRep = new JacksonRepresentation<User>(rep, User.class);
        User user = null;
        try {
            user = userRep.getObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userDao.addUser(user);
    }

}
