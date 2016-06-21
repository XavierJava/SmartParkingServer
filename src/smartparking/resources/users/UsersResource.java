package smartparking.resources.users;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

public interface UsersResource {
    @Get
    Representation getUsers();

    @Post
    String addUser(Representation rep);

    @Put
    String updateUser(Representation rep);
}
