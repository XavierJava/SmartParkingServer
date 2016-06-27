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
    public List<User> getUsers(long offset, long limit) {
        try {
            return queryBuilder().offset(offset).limit(limit).query();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserById(int userId) {
        try {
            return queryForId(userId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserByName(String name) {
        try {
            List<User> list = queryForEq("name", name);
            return list != null && list.size() > 0 ? list.get(0) : null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int addUser(User user) {
        try {
            create(user);
            return user.getId();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateUser(User user) {
        try {
            return update(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int removeUserById(int id) {
        try {
            return deleteById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
