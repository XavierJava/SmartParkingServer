package smartparking.client;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import smartparking.model.Order;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public class OrderClient {
    public static void main(String[] args) throws Exception {
        ClientResource mailClient = new ClientResource(
                "http://localhost:8111/order/3?xp=10010");
        //add
        /*Order neworder = new Order();
        neworder.setUser(new User(4, "bjut.edu", "123"));
        ParkingLot newParkingLot = new ParkingLot();
        newParkingLot.setId(10);
        newParkingLot.setName("北工大西门停车场");
        newParkingLot.setAddress("北京北京市平乐园100号啊");
        newParkingLot.setLatitude(39.9999);
        newParkingLot.setLongitude(1164867);
        newParkingLot.setAvailableSpaces(60);
        newParkingLot.setTotalSpaces(60);
        newParkingLot.setOpeningHours("8:30-22:00");
        newParkingLot.setHourlyPrice(2.9);
        newParkingLot.setNotice("周末不营业");
        neworder.setParkingLot(newParkingLot);
        neworder.setAmount(34);
        neworder.setPayed(false);
        neworder.setDate(new Date());
        JacksonRepresentation<Order> repr
                = new JacksonRepresentation<Order>(neworder);
        mailClient.post(repr);
        System.out.println(neworder);*/
        //query
        Representation result = mailClient.get();
        JacksonRepresentation jr = new JacksonRepresentation<Order>(result, Order.class);
        Order order = (Order) jr.getObject();
        System.out.println(order);
        //update
        /*order.setAmount(120);
        mailClient.put(order);*/
        //delete
        //mailClient.delete();
    }
}
