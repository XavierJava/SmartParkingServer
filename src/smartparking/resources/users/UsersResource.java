package smartparking.resources.users;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

public interface UsersResource {
    @Get
    Representation getUsers();

    @Post
    int addUser(Representation rep);

    @Put
    int updateUser(Representation rep);
}
