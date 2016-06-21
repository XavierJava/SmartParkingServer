package smartparking;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;
import smartparking.dao.OrderDao;
import smartparking.dao.ParkingLotDao;
import smartparking.dao.UserDao;
import smartparking.dao.impl.OrderDaoImpl;
import smartparking.dao.impl.ParkingLotDaoImpl;
import smartparking.dao.impl.UserDaoImpl;
import smartparking.resources.common.impl.RootServerResource;
import smartparking.resources.orders.impl.OrdersServerResource;
import smartparking.resources.orders.impl.UserOrdersServerResource;
import smartparking.resources.parkingLots.impl.NearbyParkingLotsServerResource;
import smartparking.resources.parkingLots.impl.ParkingLotServerResource;
import smartparking.resources.parkingLots.impl.ParkingLotsServerResource;
import smartparking.resources.users.impl.UserServerResource;
import smartparking.resources.users.impl.UsersServerResource;

import java.sql.SQLException;

public class SmartParkingServer extends Application {
    public SmartParkingServer() throws SQLException {
        String databaseUrl = "jdbc:mysql://localhost:3306/smartparking";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "chenhuan");

        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(connectionSource);
        UserDao userDao = new UserDaoImpl(connectionSource);
        OrderDao orderDao = new OrderDaoImpl(connectionSource);

        setName("Smart Parking Server");
        setDescription("Smart Parking Server.");
        setOwner("BJUT Smart Parking Team");
        setAuthor("BJUT Smart Parking Team");
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/", RootServerResource.class);

        router.attach("/users/{userId}", UserServerResource.class);

        router.attach("/users", UsersServerResource.class);

        router.attach("/parkinglots/{parkingLotId}", ParkingLotServerResource.class);

        router.attach("/nearby_parkinglots/{latitude}/{longitude}/{radius}",
                NearbyParkingLotsServerResource.class);

        router.attach("/parkinglots", ParkingLotsServerResource.class);

        router.attach("/orders/{orderId}", OrdersServerResource.class);

        router.attach("/orders_by_user/{userId}", UserOrdersServerResource.class);

        router.attach("/orders", OrdersServerResource.class);

        return router;
    }

    public static void startServer() throws Exception {
        Component SmartParkingServer = new Component();
        SmartParkingServer.getServers().add(Protocol.HTTP, "0.0.0.0", 8111);
        SmartParkingServer.getDefaultHost().attach(new SmartParkingServer());
        SmartParkingServer.start();
    }

    public static void main(String[] args) throws Exception {
        startServer();
    }
}
