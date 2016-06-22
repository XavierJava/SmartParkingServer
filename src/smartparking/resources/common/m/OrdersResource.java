package smartparking.resources.common.m;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import smartparking.model.Order;

import java.util.List;


public interface OrdersResource {
    @Get
    List getOrders();

    @Post
    int addOrder(Order order);

    @Put
    int updateOrder(Order order);
}
