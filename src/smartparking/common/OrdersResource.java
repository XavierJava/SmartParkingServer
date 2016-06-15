package smartparking.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public interface OrdersResource {
    @Get
    Representation getOrders();

    @Post
    String addOrder(Representation rep);

    @Put
    String editOrder(Representation rep);

}
