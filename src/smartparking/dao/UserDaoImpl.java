package smartparking.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenhuanhuan on 16-5-19.
 */
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
    public UserDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, User.class);
    }

    @Override
    public List getUsers() throws SQLException {
        return super.queryForAll();
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        return super.queryForId(userId);
    }

    @Override
    public User getUserByName(String name) throws SQLException {
        return super.queryForEq("name", name).get(0);
    }

    @Override
    public String addUser(User user) throws SQLException {
        if (getUserByName(user.getName()) != null)
            return "请换一个用户名试试.";
        if (super.create(user) > 0)
            return "注册成功.";
        else
            return "注册失败";
    }

    @Override
    public void editUser(User user) throws SQLException {
        super.update(user);
    }

    @Override
    public void removeUserById(int id) throws SQLException {
        super.deleteById(id);
    }
}
