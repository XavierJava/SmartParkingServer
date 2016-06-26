package smartparking;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;
import smartparking.resources.impl.*;

import java.sql.SQLException;

public class SmartParkingServer extends Application {
    public SmartParkingServer() throws SQLException {
        setName("Smart Parking Server");
        setDescription("Smart Parking Server.");
        setOwner("BJUT Smart Parking Team");
        setAuthor("BJUT Smart Parking Team");

    }

    public static void main(String[] args) throws Exception {
        startServer();
    }

    private static void startServer() throws Exception {
        Component SmartParkingServer = new Component();
        SmartParkingServer.getServers().add(Protocol.HTTP, "0.0.0.0", 8111);
        SmartParkingServer.getDefaultHost().attach(new SmartParkingServer());
        SmartParkingServer.start();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/", RootServerResource.class);

        router.attach("/user/{idOrName}", UserServerResource.class);

        router.attach("/users", UsersServerResource.class);

        router.attach("/parking_lot/{idOrName}", ParkingLotServerResource.class);

        router.attach("/parking_lots", ParkingLotsServerResource.class);

        router.attach("/nearby_parking_lots/{latitude}/{longitude}/{radius}", NearbyParkingLotsServerResource.class);

        router.attach("/order/{orderId}", OrderServerResource.class);

        router.attach("/orders/{userIdOrParkingLotId}", OrdersServerResource.class);

        router.attach("/orders/{userId}/{parkingLotId}", OrdersServerResource.class);

        router.attach("/orders", OrdersServerResource.class);

        return router;
    }
}
