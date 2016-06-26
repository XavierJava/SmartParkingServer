package smartparking.resources.impl;

import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.UserDao;
import smartparking.model.User;
import smartparking.resources.UsersResource;

import java.util.List;

public class UsersServerResource extends ServerResource implements UsersResource {
    UserDao userDao;
    /**
     * 页号
     */
    private String page;
    /**
     * 每页显示的项目数
     */
    private String count;

    @Override
    protected void doInit() {
        super.doInit();
        page = getQueryValue("p");
        count = getQueryValue("c");
        userDao = Settings.getUserDao();
    }


    @Override
    public List getUsers() {
        int page = 1;
        long limit = 10l;
        long offset = 1;
        if (this.page != null && this.page.matches("^[0-9]*[1-9][0-9]*$")) {
            page = Integer.parseInt(this.page);
        }

        if (this.count != null && this.count.matches("^[0-9]*[1-9][0-9]*$")) {
            limit = Long.parseLong(this.count);
        }
        offset = (page - 1) * limit + 1;
        return userDao.getUsers(offset, limit);
    }


    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {

        return userDao.updateUser(user);
    }
}
