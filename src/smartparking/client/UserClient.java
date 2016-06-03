package smartparking.client;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Protocol;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import smartparking.common.UsersResource;
import smartparking.model.User;

public class UserClient {
    public static void main(String[] args) throws Exception {
        Client client = new Client(new Context(), Protocol.HTTPS);
        ClientResource clientResource = new ClientResource(
                "http://localhost:8111/user/4");
        clientResource.setNext(client);
        ChallengeResponse authentication = new ChallengeResponse(
                ChallengeScheme.HTTP_BASIC, "huanlove", "chh912");
        clientResource.setChallengeResponse(authentication);

        UsersResource userClient = clientResource.wrap(UsersResource.class);
        Representation result = userClient.getUser();// clientResource.get()

        JacksonRepresentation jr = new JacksonRepresentation<User>(result, User.class);
        User user = (User) jr.getObject();
        System.out.println(user);

        //query
        /*Representation result = mailClient.get();
       JacksonRepresentation jr = new JacksonRepresentation<User>(result,User.class);
        User user = (User)jr.getObhuanloveject();
        System.out.println(user);*/
        //add
        User user1 = new User();
        user1.setName("huanhuan");
        user1.setPassword("hh");
        JacksonRepresentation<User> repr
                = new JacksonRepresentation<User>(user1);
        clientResource.post(repr);
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
        client.stop();
    }
}
