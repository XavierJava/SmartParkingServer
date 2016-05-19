package smartparking.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-19.
 */
public class UserDaoImpl extends BaseDaoImpl<User, Integer> {
    public UserDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, User.class);
    }

    //return all users
    public List getUsers() throws SQLException {
        return super.queryForAll();
    }

    public User getUserById(int userid) throws SQLException {
        return super.queryForId(userid);
    }

    public User getUserByName(String name) throws SQLException {
        return super.queryForEq("name", name).get(0);
    }

    public boolean addUser(User user) throws SQLException {
        return super.create(user) > 0;
    }

    public void editUser(User user) throws SQLException {
        super.update(user);
    }

    public void removeUserById(int id) throws SQLException {
        super.deleteById(id);
    }
}
