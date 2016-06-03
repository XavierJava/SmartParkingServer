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
        //GET
        router.attach("/user/{userId}",
                UsersServerResource.class);
        //POST,PUT,DELETE
        router.attach("/user",
                UsersServerResource.class);
        //GET
        router.attach("/parkinglot/{parkingLotId}",
                ParkingLotsServerResource.class);
        router.attach("/parkinglots/name/{parkingLotName}",
                ParkingLotsServerResource.class);
        router.attach("/parkinglots/near/{latitude-longitude-radius}",
                ParkingLotsServerResource.class);
        //POST,PUT,DELETE
        router.attach("/parkinglot",
                ParkingLotsServerResource.class);
        //GET
        router.attach("/order/{orderId}",
                OrdersServerResource.class);
        router.attach("/user/orders/{userId}",
                OrdersServerResource.class);
        router.attach("/user/{userId}/parkinglot/{parkingLotId}",
                OrdersServerResource.class);
        //POST,PUT,DELETE
        router.attach("/order",
                OrdersServerResource.class);
        /*ChallengeAuthenticator authenticator = new ChallengeAuthenticator(
                getContext(), ChallengeScheme.HTTP_BASIC, "My Realm");
        authenticator.setVerifier(new LoginVerifier(userDao));
        authenticator.setNext(router);
        return authenticator;*/
        return router;
    }
}
