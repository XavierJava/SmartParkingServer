package smartparking.client;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import smartparking.model.ParkingLot;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public class ParkingLotClient {
    public static void main(String[] args) throws Exception {
        ClientResource mailClient = new ClientResource(
                "http://localhost:8111/parkinglots/8");

        //query
        Representation result = mailClient.get();
        JacksonRepresentation jr = new JacksonRepresentation<ParkingLot>(result, ParkingLot.class);
        ParkingLot parkingLot = (ParkingLot) jr.getObject();
        System.out.println(parkingLot);
        //add
        /*ParkingLot newParkingLot = new ParkingLot();
        newParkingLot.setName("北工大西门停车场");
        newParkingLot.setAddress("北京北京市平乐园100号啊");
        newParkingLot.setLatitude(39.9999);
        newParkingLot.setLongitude(1164867);
        newParkingLot.setAvailableSpaces(60);
        newParkingLot.setTotalSpaces(60);
        newParkingLot.setOpeningHours("8:30-22:00");
        newParkingLot.setHourlyPrice(2.9);
        newParkingLot.setNotice("周末不营业");
        JacksonRepresentation<ParkingLot> repr
                = new JacksonRepresentation<ParkingLot>(newParkingLot);
        mailClient.post(repr);*/
        //update
       /* Representation result = mailClient.get();
        JacksonRepresentation jr = new JacksonRepresentation<ParkingLot>(result, ParkingLot.class);
        ParkingLot parkingLot = (ParkingLot) jr.getObject();
        parkingLot.setName("beijing university of technology");
        mailClient.put(parkingLot);*/
        //delete
       /* mailClient.delete();
        JacksonRepresentation jr = new JacksonRepresentation<ParkingLot>(result, ParkingLot.class);
        ParkingLot parkingLot = (ParkingLot) jr.getObject();
        System.out.println("已删除:" + parkingLot);*/
    }
}
