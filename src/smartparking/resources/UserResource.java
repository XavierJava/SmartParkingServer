package smartparking.resources;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import smartparking.model.User;

/**
 * 获取单个用户,删除用户的接口
 */
public interface UserResource {

    @Get
    User getUser();

    @Delete
    int removeUser();
}
