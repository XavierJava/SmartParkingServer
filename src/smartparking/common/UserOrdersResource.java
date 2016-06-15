package smartparking.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;

/**
 * Created by chenhuanhuan on 16-6-15.
 */
public interface UserOrdersResource {
    @Get
    Representation getOrders();
}
