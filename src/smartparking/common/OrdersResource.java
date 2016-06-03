package smartparking.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

import java.sql.SQLException;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public interface OrdersResource {
    @Get
    Representation getOrder() throws SQLException;

    @Post
    void addOrder(Representation rep) throws SQLException;

    @Delete
    void removeOrder(int orderId) throws SQLException;

    @Put
    void editOrder(Representation rep) throws SQLException;

}
