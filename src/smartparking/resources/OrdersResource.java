package smartparking.resources;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import smartparking.model.Order;

import java.util.List;

/**
 * 获取订单,新建订单,更新订单的接口
 */
public interface OrdersResource {
    @Get
    List<Order> getOrders();

    @Post
    int addOrder(Order order);

    @Put
    int updateOrder(Order order);
}
