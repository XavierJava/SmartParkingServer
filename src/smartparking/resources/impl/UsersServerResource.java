package smartparking.resources.impl;

import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.UserDao;
import smartparking.model.User;
import smartparking.resources.UsersResource;

import java.util.List;

public class UsersServerResource extends ServerResource implements UsersResource {
    UserDao userDao;

    @Override
    protected void doInit() {
        super.doInit();
        userDao = Settings.getUserDao();
    }


    @Override
    public List getUsers() {
        return userDao.getUsers();
    }


    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {

        return userDao.updateUser(user);
    }
}
