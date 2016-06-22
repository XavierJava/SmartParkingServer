package smartparking.resources.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;

public interface UserResource {
    @Get
    Representation getUser();

    @Delete
    String removeUser();
}
