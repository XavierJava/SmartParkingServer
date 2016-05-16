package smartparking.service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import smartparking.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    Dao<User, Integer> userDao;

    public UserServiceImpl(ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, User.class);
        userDao = DaoManager.createDao(connectionSource, User.class);
    }

    @Override
    public List<User> getUsers() throws SQLException {
        return userDao.queryForAll();
    }

    @Override
    public User getUserById(int id) throws SQLException {
        return userDao.queryForId(id);
    }

    @Override
    public User getUserByName(String name) throws SQLException {
        return userDao.queryForEq("name", name).get(0);
    }

    @Override
    public void addUser(User user) throws SQLException {
        userDao.create(user);
    }

    @Override
    public void editUser(User user) throws SQLException {
        userDao.update(user);
    }

    @Override
    public void removeUserById(int id) throws SQLException {
        userDao.deleteById(id);
    }
}
