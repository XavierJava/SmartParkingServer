package smartparking.api;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import smartparking.dao.UserDaoImpl;
import smartparking.model.User;

import java.sql.SQLException;
import java.util.List;

public class ApiImpl implements Api {
    UserDaoImpl userDao;

    public ApiImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean register(String name, String password) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return userDao.addUser(user);
    }

    @Override
    public boolean login(String name, String password) throws SQLException {
        List<User> userList;
        QueryBuilder<User, Integer> queryBuilder = userDao.queryBuilder();
        Where<User, Integer> where = queryBuilder.where();
        where.and(where.eq("name", name), where.eq("pswd", password));
        PreparedQuery preparedQuery = queryBuilder.prepare();
        userList = userDao.query(preparedQuery);
        // System.out.println(userList.get(0));
        return userList.size() > 0;
    }
}
