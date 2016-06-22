package smartparking.resources.common.m;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import smartparking.model.User;

import java.util.List;

public interface UsersResource {
    @Get
    List getUsers();

    @Put
    int updateUser(User user);

    @Post
    int addUser(User user);
}
