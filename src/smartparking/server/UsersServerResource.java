package smartparking.server;

import org.restlet.Request;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.UsersResource;
import smartparking.dao.SingleConnectionSource;
import smartparking.dao.UserDaoImpl;
import smartparking.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class UsersServerResource extends ServerResource implements UsersResource {
    int userId;
    UserDaoImpl userDao;
    @Override
    protected void doInit() {
        super.doInit();
        String userIdAttribute = getAttribute("userId");
        System.out.println("用户id:" + userIdAttribute);
        try {
            userDao = new UserDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //throw new ResourceException(Status.SERVER_ERROR_INTERNAL, "服务器内部错误.", e);
        }
        if (userIdAttribute != null) {
            this.userId = Integer.parseInt(userIdAttribute);
            setName("Resource for parking account '" + this.userId + "'");
            setDescription("The resource describing the parking account number '"
                    + this.userId + "'");
        } else {
            setName("parking account resource");
            setDescription("The resource describing a parking account");
        }
    }


    @Override
    public Representation getUser() {
        User user = null;
        try {
            user = userDao.getUserById(userId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //response.setStatus(Status.SERVER_ERROR_INTERNAL, "服务器内部错误.");
            return new StringRepresentation("服务器内部错误", MediaType.TEXT_PLAIN);
            //throw new ResourceException(Status.SERVER_ERROR_INTERNAL, "服务器内部错误.", e);
        }
        if (user == null) {
            System.out.println("user==null");
            //response.setStatus(Status.CLIENT_ERROR_BAD_REQUEST, "不存在的用户id.");
            //throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "不存在的用户id.");
            String errorMessage = "不存在此ID";
            Request request = this.getRequest();
            request.setEntity(errorMessage, MediaType.TEXT_PLAIN);
            Status status = new Status(
                    Status.CLIENT_ERROR_BAD_REQUEST, errorMessage);
            throw new ResourceException(status);
            //return new StringRepresentation("不存在的用户id", MediaType.TEXT_PLAIN);
        }
        return new JacksonRepresentation<User>(user);
    }

    @Override
    public void updateUser(Representation rep) throws IOException, SQLException {
        JacksonRepresentation<User> userRep = new JacksonRepresentation<User>(rep, User.class);
        User user = userRep.getObject();
        userDao.editUser(user);
    }

    @Override
    public String addUser(Representation rep) throws IOException, SQLException {
        JacksonRepresentation<User> userRep = new JacksonRepresentation<User>(rep, User.class);
        User user = userRep.getObject();
        return userDao.addUser(user);
    }

    @Override
    public void removeUser(int userId) throws SQLException {
        System.out.println("删除" + userId);
        userDao.removeUserById(userId);
    }
}
