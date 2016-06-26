package smartparking.api.impl;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import smartparking.api.OrderApi;
import smartparking.model.Order;
import smartparking.resources.OrderResource;
import smartparking.resources.OrdersResource;

import java.util.List;

public class OrderApiImpl implements OrderApi {
    private ClientResource service = new ClientResource("http://localhost:8111");

    public OrderApiImpl() {
        service.setNext(new Client(new Context(), Protocol.HTTP));
    }

    @Override
    public Order getOrderById(int orderId) {
        OrderResource orderResource = service.getChild("/order/" + orderId, OrderResource.class);
        return orderResource.getOrder();
    }


    @Override
    public List<Order> getOrders(int page, int count) {
        OrdersResource ordersResource = service.getChild("/orders?p=" + page + "&c=" + count, OrdersResource.class);
        return ordersResource.getOrders();
    }


    @Override
    public List<Order> getOrderByUserIdAndParkingLotId(int userId, int parkingLotId, int page, int count) {
        OrdersResource ordersResource = service.getChild("/orders/" + userId + "/" + parkingLotId + "?p=" + page + "&c=" + count, OrdersResource.class);
        return ordersResource.getOrders();
    }

    @Override
    public List<Order> getOrdersByUserId(int userId, int page, int count) {
        OrdersResource ordersResource = service.getChild("/orders/" + userId + "?q=user&p=" + page + "&c=" + count, OrdersResource.class);
        return ordersResource.getOrders();
    }

    @Override
    public List<Order> getOrdersByParkingLotId(int parkingLotId, int page, int count) {
        OrdersResource ordersResource = service.getChild("/orders/" + parkingLotId + "?q=parkingLot&p=" + page + "&c=" + count, OrdersResource.class);
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
