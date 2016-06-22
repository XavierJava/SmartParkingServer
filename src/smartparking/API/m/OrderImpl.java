package smartparking.API.m;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import smartparking.API.OrderApi;
import smartparking.model.Order;
import smartparking.resources.common.m.OrderResource;
import smartparking.resources.common.m.OrdersResource;

import java.util.List;

public class OrderImpl implements OrderApi {
    private Client client = new Client(new Context(), Protocol.HTTP);
    private ClientResource service = new ClientResource("http://localhost:8111");

    @Override
    public List<Order> getOrders() {
        OrdersResource ordersResource = service.getChild("/orders", OrdersResource.class);

        return ordersResource.getOrders();
    }

    @Override
    public Order getOrderById(int orderId) {
        OrderResource orderResource = service.getChild("/order/" + orderId, OrderResource.class);
        return orderResource.getOrder();
    }


    @Override
    public List getOrderByUserIdAndParkingLotId(int userId, int parkingLotId) {
        OrdersResource ordersResource = service.getChild("/orders/" + userId + "/" + parkingLotId, OrdersResource.class);

        return ordersResource.getOrders();
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        OrdersResource ordersResource = service.getChild("/orders/" + userId + "?q=user", OrdersResource.class);

        return ordersResource.getOrders();
    }

    @Override
    public List getOrdersByParkingLotId(int parkingLotId) {
        OrdersResource ordersResource = service.getChild("/orders/" + parkingLotId + "?q=parkingLot", OrdersResource.class);

        return ordersResource.getOrders();
    }

    @Override
    public int addOrder(Order order) {
        OrdersResource ordersResource = service.getChild("/orders", OrdersResource.class);

        return ordersResource.addOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        OrdersResource ordersResource = service.getChild("/orders", OrdersResource.class);

        return ordersResource.updateOrder(order);
    }

    @Override
    public int removeOrderById(int orderId) {
        OrderResource orderResource = service.getChild("/order/" + orderId, OrderResource.class);
        return orderResource.removeOrder();
    }
}
