package smartparking.resources.orders;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

public interface OrdersResource {
    @Get
    Representation getOrders();

    @Post
    String addOrder(Representation rep);

    @Put
    String updateOrder(Representation rep);
}
