package smartparking.resources.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;


public interface UserOrdersResource {
    @Get
    Representation getOrders();
}
