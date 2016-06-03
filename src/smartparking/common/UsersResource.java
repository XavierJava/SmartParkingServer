package smartparking.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

import java.io.IOException;
import java.sql.SQLException;

public interface UsersResource {
    @Get
    Representation getUser() throws SQLException;

    @Delete
    public void removeUser(int userId) throws SQLException, IOException;

    @Post
    public void addUser(Representation rep) throws SQLException, IOException;

    @Put
    public void updateUser(Representation rep) throws SQLException, IOException;
}
