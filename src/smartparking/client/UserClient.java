package smartparking.client;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import smartparking.common.UsersResource;

public class UserClient {
    public static void main(String[] args) {
        Client client = new Client(new Context(), Protocol.HTTPS);
        ClientResource clientResource = new ClientResource(
                "http://localhost:8111/user/7");
        clientResource.setNext(client);
        /*ChallengeResponse authentication = new ChallengeResponse(
                ChallengeScheme.HTTP_BASIC, "huanlove", "chh912");
        clientResource.setChallengeResponse(authentication);*/

        UsersResource userClient = clientResource.wrap(UsersResource.class);
        //userClient.getUser();//
        //Response response = Response.getCurrent();
        //Status status = response.getStatus();
        try {
            Representation result = clientResource.get();
        } catch (ResourceException e) {
            Status status = e.getStatus();
            System.out.println(status.getCode() + "\ndesc:" + status.getDescription() + "\nphrase:" + status.getReasonPhrase() + "\nuri:" + status.getUri());
            //log.error( "Error: " + status.getDescription() );
            //log.error( "Error: " + status.getCode() );
            System.out.println("\nResourceException.getMessage:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nException.getMessage:" + e.getMessage());
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        /*if (status.isSuccess()) {
            JacksonRepresentation jr = new JacksonRepresentation<User>(result, User.class);
            User user = (User) jr.getObject();
            System.out.println(user);
        } else {

        }*/

        //add
        /*User user1 = new User();
        user1.setName("huanhuan");
        user1.setPassword("hh");
        JacksonRepresentation<User> repr
                = new JacksonRepresentation<User>(user1);
        System.out.println(clientResource.post(repr).getText());*/

        //update
       /* Representation result = mailClient.get();
        JacksonRepresentation jr = new JacksonRepresentation<User>(result, User.class);
        User user = (User) jr.getObject();
        user.setEmail("111@111.com");
        mailClient.put(user);*/
        //delete
        //mailClient.delete();
        //JacksonRepresentation jr = new JacksonRepresentation<User>(result, User.class);
        //User user = (User) jr.getObject();
        //System.out.println("已删除:" + user);

    }
}
