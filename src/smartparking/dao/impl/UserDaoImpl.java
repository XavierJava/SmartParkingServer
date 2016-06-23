package smartparking.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.dao.UserDao;
import smartparking.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
    public UserDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, User.class);
    }

    @Override
    public List<User> getUsers() {
        List<User> list = null;
        try {
            list = queryForAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try {
            user = queryForId(userId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = null;
        try {
            user = queryForEq("name", name).get(0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        int flag = 0;
        try {
            flag = create(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @Override
    public int updateUser(User user) {
        int flag = 0;
        try {
            flag = update(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @Override
    public int removeUserById(int id) {
        int flag = 0;
        try {
            flag = deleteById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
