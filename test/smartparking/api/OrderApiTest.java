package smartparking.api;

import org.junit.Before;
import org.junit.Test;
import smartparking.api.impl.OrderApiImpl;
import smartparking.model.Order;
import smartparking.model.ParkingLot;
import smartparking.model.User;

public class OrderApiTest {
    private OrderApi orderApi = new OrderApiImpl();
    private Order order = new Order();
    private User user = new User();
    private ParkingLot parkingLot = new ParkingLot();
    private int page = 1;
    private int count = 3;

    @Before
    public void setUp() {
        user.setId(3);
        parkingLot.setId(3);
        order.setAmount(54);
        order.setUser(user);
        order.setParkingLot(parkingLot);
    }

    @Test
    public void testAddOrder() {
        assert orderApi.addOrder(order) > 0;
    }

    @Test
    public void testGetOrders() {
        assert orderApi.getOrders(page, count).size() > 0;
    }

    @Test
    public void testGetOrderById() {
        assert orderApi.getOrderById(6) != null;
    }

    @Test
    public void testGetOrdersByUserId() {
        assert orderApi.getOrdersByUserId(5, page, count).size() == 0;
    }

    @Test
    public void testGetOrdersByParkingLotId() {
        assert orderApi.getOrdersByParkingLotId(1, page, count).size() > 0;
    }

    @Test
    public void testOrderByUserIdAndParkingLotId() {
        assert orderApi.getOrderByUserIdAndParkingLotId(2, 1, page, count).size() > 0;
    }

    @Test
    public void testUpdateOrder() {
        order.setId(8);
        order.setPaid(true);
        assert orderApi.updateOrder(order) > 0;
    }

    @Test
    public void testRemoveOrder() {
        assert orderApi.removeOrderById(4) > 0;
    }
}
