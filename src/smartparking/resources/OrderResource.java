package smartparking.resources;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import smartparking.model.Order;


public interface OrderResource {
    @Get
    Order getOrder();

    @Delete
    int removeOrder();
}
