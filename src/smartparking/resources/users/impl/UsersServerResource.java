package smartparking.resources.users.impl;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;
import smartparking.SingleConnectionSource;
import smartparking.dao.impl.UserDaoImpl;
import smartparking.model.User;
import smartparking.resources.users.UsersResource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UsersServerResource extends ServerResource implements UsersResource {
    UserDaoImpl userDao;

    @Override
    protected void doInit() {
        super.doInit();
        try {
            userDao = new UserDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public Representation getUsers() {
        List users;
        users = userDao.getUsers();
        return users == null ? new StringRepresentation("不存在用户", MediaType.TEXT_PLAIN) :
                new JacksonRepresentation<>(users);
    }

    @Override
    public String updateUser(Representation rep) {
        JacksonRepresentation<User> userRep = new JacksonRepresentation<User>(rep, User.class);
        User user = null;
        try {
            userRep.getObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userDao.editUser(user) > 0 ? "修改成功" : "修改失败";
    }

    @Override
    public String addUser(Representation rep) {
        JacksonRepresentation<User> userRep = new JacksonRepresentation<User>(rep, User.class);
        User user = null;
        try {
            user = userRep.getObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userDao.addUser(user) > 0 ? "添加成功" : "添加失败";
    }

}
