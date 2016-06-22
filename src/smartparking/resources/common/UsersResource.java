package smartparking.resources.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

public interface UsersResource {
    @Get
    Representation getUsers();

    @Put
    int updateUser(Representation rep);

    @Post
    int addUser(Representation rep);
}
