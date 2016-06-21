package smartparking.resources.users.impl;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;
import smartparking.SingleConnectionSource;
import smartparking.dao.impl.UserDaoImpl;
import smartparking.model.User;
import smartparking.resources.users.UserResource;

import java.sql.SQLException;

public class UserServerResource extends ServerResource implements UserResource {
    String userIdAttribute;
    UserDaoImpl userDao;

    @Override
    protected void doInit() {
        super.doInit();
        userIdAttribute = getAttribute("userId");
        try {
            userDao = new UserDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Representation getUser() {
        if (userIdAttribute == null || !userIdAttribute.matches("^[0-9]*[1-9][0-9]*$"))
            return new StringRepresentation("参数类型错误");
        User user = null;
        user = userDao.getUserById(Integer.parseInt(userIdAttribute));
        return user == null ? new StringRepresentation("不存在该用户", MediaType.TEXT_PLAIN) :
                new JacksonRepresentation<User>(user);
    }

    @Override
    public String removeUser() {
        if (userIdAttribute == null || !userIdAttribute.matches("^[0-9]*[1-9][0-9]*$"))
            return "参数类型错误";
        return userDao.removeUserById(Integer.parseInt(userIdAttribute)) > 0 ? "删除成功" : "删除失败";
    }
}
