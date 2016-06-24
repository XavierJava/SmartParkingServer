package smartparking.resources;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import smartparking.model.User;

public interface UserResource {
    @Get
    User getUser();

    @Delete
    int removeUser();
}
