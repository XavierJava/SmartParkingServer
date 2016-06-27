package smartparking.api;

import org.junit.Test;
import smartparking.api.impl.OrderApiImpl;
import smartparking.model.Order;
import smartparking.model.ParkingLot;
import smartparking.model.User;

public class OrderApiTest {
    private OrderApi orderApi = new OrderApiImpl();
    private int page = 1;
    private int count = 3;

    @Test
    public void testAddOrder() {
        User user = new User();
        user.setId(1);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        Order order = new Order();
        order.setAmount(22.0);
        order.setUser(user);
        order.setParkingLot(parkingLot);
        assert orderApi.addOrder(order) >= 1;
    }
    @Test
    public void testGetOrderById() {
        User user = new User();
        user.setId(2);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(2);
        Order order = new Order();
        order.setAmount(33.0);
        order.setUser(user);
        order.setParkingLot(parkingLot);
        assert orderApi.getOrderById(orderApi.addOrder(order)).getUser().getId() == 2;
    }

    @Test(timeout = 5000l)
    public void testGetOrders() {
        assert orderApi.getOrders(page, count).size() == count;
    }


    @Test
    public void testGetOrdersByUserId() {
        User user = new User();
        user.setId(16);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(16);
        Order order = new Order();
        order.setAmount(33.0);
        order.setUser(user);
        order.setParkingLot(parkingLot);
        orderApi.addOrder(order);
        orderApi.addOrder(order);
        orderApi.addOrder(order);
        assert orderApi.getOrdersByUserId(16, 2, 2).size() == 1;
    }

    @Test
    public void testGetOrdersByParkingLotId() {
        User user = new User();
        user.setId(7);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(7);
        Order order = new Order();
        order.setAmount(22.0);
        order.setUser(user);
        order.setParkingLot(parkingLot);
        orderApi.addOrder(order);
        orderApi.addOrder(order);
        orderApi.addOrder(order);
        assert orderApi.getOrdersByParkingLotId(7, page, count).size() == count;
    }

    @Test
    public void testOrderByUserIdAndParkingLotId() {
        User user = new User();
        user.setId(8);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(8);
        Order order = new Order();
        order.setAmount(22.0);
        order.setUser(user);
        order.setParkingLot(parkingLot);
        orderApi.addOrder(order);
        orderApi.addOrder(order);
        orderApi.addOrder(order);
        assert orderApi.getOrderByUserIdAndParkingLotId(8, 8, page, count).size() == count;
    }

    @Test
    public void testUpdateOrder() {
        User user = new User();
        user.setId(3);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(3);
        Order order = new Order();
        order.setAmount(11.0);
        order.setUser(user);
        order.setParkingLot(parkingLot);
        Order order1 = orderApi.getOrderById(orderApi.addOrder(order));
        order1.setPaid(true);
        assert orderApi.updateOrder(order1) == 1;
    }

    @Test
    public void testRemoveOrder() {
        User user = new User();
        user.setId(4);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(4);
        Order order = new Order();
        order.setAmount(22.0);
        order.setUser(user);
        order.setParkingLot(parkingLot);
        assert orderApi.removeOrderById(orderApi.addOrder(order)) == 1;
    }
}
