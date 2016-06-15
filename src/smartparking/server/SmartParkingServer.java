package smartparking.server;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;
import smartparking.dao.OrderDaoImpl;
import smartparking.dao.ParkingLotDaoImpl;
import smartparking.dao.UserDaoImpl;

import java.sql.SQLException;

public class SmartParkingServer extends Application {
    String databaseUrl;
    ConnectionSource connectionSource;
    ParkingLotDaoImpl parkingLotDao;
    UserDaoImpl userDao;
    OrderDaoImpl orderDao;

    public SmartParkingServer() throws SQLException {
        databaseUrl = "jdbc:mysql://localhost:3306/smartparking";
        connectionSource = new JdbcConnectionSource(databaseUrl, "root", "chenhuan");
        parkingLotDao = new ParkingLotDaoImpl(connectionSource);
        userDao = new UserDaoImpl(connectionSource);
        orderDao = new OrderDaoImpl(connectionSource);
        //TableUtils.createTableIfNotExists(connectionSource, User.class);
        //TableUtils.createTableIfNotExists(connectionSource, ParkingLot.class);
        //TableUtils.createTableIfNotExists(connectionSource, Order.class);
        setName("RESTful Smart Parking Server application");
        setDescription("I am smartparking application's server side.");
        setOwner("BJUT");
        setAuthor("The SmartParking Team @ BJUT");
        //setStatusService(new SmartParkingStatusService());
    }

    public static void main(String[] args) throws Exception {
        Component SmartParkingServer = new Component();
        SmartParkingServer.getServers().add(Protocol.HTTP, "0.0.0.0", 8111);
        SmartParkingServer.getDefaultHost().attach(new SmartParkingServer());
        SmartParkingServer.start();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/", RootServerResource.class);
        //GET,DELETE
        router.attach("/users/{userId}",
                UserServerResource.class);
        //POST,PUT
        router.attach("/users",
                UsersServerResource.class);
        //GET,DELETE
        router.attach("/parkinglots/{parkingLotId}",
                ParkingLotServerResource.class);
        //附近的停车场
        router.attach("/parkinglots/latitude/{latitude}/longitude/{longitude}/radius/{radius}",
                NearParkingLotsServerResource.class);
        //POST,PUT
        router.attach("/parkinglots",
                ParkingLotsServerResource.class);
        //GET,DELETE
        router.attach("/orders/{orderId}",
                OrdersServerResource.class);
        //某用户的所有订单
        router.attach("/users/{userId}/orders",
                UserOrdersServerResource.class);
        //POST,PUT
        router.attach("/orders",
                OrdersServerResource.class);
        /*ChallengeAuthenticator authenticator = new ChallengeAuthenticator(
                getContext(), ChallengeScheme.HTTP_BASIC, "My Realm");
        authenticator.setVerifier(new LoginVerifier(userDao));
        authenticator.setNext(router);
        return authenticator;*/
        return router;
    }
}
