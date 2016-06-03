package smartparking.server;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
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
    protected void doInit() throws ResourceException {
        super.doInit();
        String userIdAttribute = getAttribute("userId");
        System.out.println("用户id:" + userIdAttribute);
        //org.restlet.startTime&&org.restlet.http.headers
        //getRequestAttributes().forEach((x,y)->System.out.println(x+"="+y));
        try {
            userDao = new UserDaoImpl(SingleConnectionSource.getConnectionSource());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
    public Representation getUser() throws SQLException {
        System.out.println("查询" + userId);
        User user = userDao.getUserById(userId);
        return new JacksonRepresentation<User>(user);
    }

    @Override
    public void updateUser(Representation rep) throws IOException, SQLException {
        JacksonRepresentation<User> userRep = new JacksonRepresentation<User>(rep, User.class);
        User user = userRep.getObject();
        userDao.editUser(user);
    }

    @Override
    public void addUser(Representation rep) throws IOException, SQLException {
        JacksonRepresentation<User> userRep = new JacksonRepresentation<User>(rep, User.class);
        User user = userRep.getObject();
        userDao.addUser(user);
    }

    @Override
    public void removeUser(int userId) throws SQLException {
        System.out.println("删除" + userId);
        userDao.removeUserById(userId);
    }
}
