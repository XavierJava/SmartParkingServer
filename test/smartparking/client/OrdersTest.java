package smartparking.client;

import org.junit.Before;
import org.junit.Test;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import smartparking.model.Order;

import java.io.IOException;

public class OrdersTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetOrder() throws IOException {
        String orderId = "3";

        ClientResource orderResource = new ClientResource(
                "http://localhost:8111" + "/order/" + orderId);

        Representation result = orderResource.get();
        JacksonRepresentation jr = new JacksonRepresentation<>(result, Order.class);

        Order order = (Order) jr.getObject();

        System.out.println(order);
    }
}
