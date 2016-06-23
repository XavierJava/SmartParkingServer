package smartparking.API;

import org.junit.Before;
import org.junit.Test;
import smartparking.API.m.OrderImpl;
import smartparking.model.Order;
import smartparking.model.ParkingLot;
import smartparking.model.User;

public class OrderLotImplTest {
    private OrderImpl orderImpl = new OrderImpl();
    private Order order = new Order();
    private User user = new User();
    private ParkingLot parkingLot = new ParkingLot();

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
        assert orderImpl.addOrder(order) > 0;
    }

    @Test
    public void testGetOrders() {
        assert orderImpl.getOrders().size() > 0;
    }

    @Test
    public void testGetOrderById() {
        assert orderImpl.getOrderById(6) != null;
    }

    @Test
    public void testGetOrdersByUserId() {
        assert orderImpl.getOrdersByUserId(5).size() == 0;
    }

    @Test
    public void testGetOrdersByParkingLotId() {
        assert orderImpl.getOrdersByParkingLotId(1).size() > 0;
    }

    @Test
    public void testOrderByUserIdAndParkingLotId() {
        assert orderImpl.getOrderByUserIdAndParkingLotId(2, 1).size() > 0;
    }

    @Test
    public void testUpdateOrder() {
        order.setId(8);
        order.setPaid(true);
        assert orderImpl.updateOrder(order) > 0;
    }

    @Test
    public void testRemoveOrder() {
        assert orderImpl.removeOrderById(4) > 0;
    }
}
