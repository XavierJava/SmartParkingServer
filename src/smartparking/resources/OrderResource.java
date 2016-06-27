package smartparking.resources;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import smartparking.model.Order;

/**
 * 获取单个订单,删除订单的接口
 */

public interface OrderResource {
    @Get
    Order getOrder();

    @Delete
    int removeOrder();
}
