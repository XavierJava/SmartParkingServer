package smartparking.client;

import org.restlet.resource.ClientResource;

/**
 * Created by chenhuanhuan on 16-5-23.
 */
public class ParkingLotClient {
    public static void main(String[] args) throws Exception {
        ClientResource parkingLotClient = new ClientResource(
                "http://localhost:8111/parkinglots");

        //query
        System.out.println(parkingLotClient.get().getText());
        //add
        /*ParkingLot newParkingLot = new ParkingLot();
        newParkingLot.setName("农光里小区南门停车场");
        newParkingLot.setAddress("北京市朝阳区？号");
        newParkingLot.setLatitude(39.9999);
        newParkingLot.setLongitude(1164867);
        newParkingLot.setAvailableSpaces(60);
        newParkingLot.setTotalSpaces(60);
        newParkingLot.setOpeningHours("8:30-22:00");
        newParkingLot.setHourlyPrice(2.9);
        newParkingLot.setNotice("周末营业");
        JacksonRepresentation<ParkingLot> repr
                = new JacksonRepresentation<ParkingLot>(newParkingLot);
        System.out.println(parkingLotClient.post(repr).getText());*/
        //update
       /* Representation result = mailClient.get();
        JacksonRepresentation jr = new JacksonRepresentation<ParkingLot>(result, ParkingLot.class);
        ParkingLot parkingLot = (ParkingLot) jr.getObject();
        parkingLot.setName("beijing university of technology");
        parkingLotClient.put(parkingLot);*/
        //delete
        //System.out.println(parkingLotClient.delete().getText());
    }
}
