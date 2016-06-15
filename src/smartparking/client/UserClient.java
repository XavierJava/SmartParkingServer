package smartparking.client;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

public class UserClient {
    public static void main(String[] args) throws Exception {
        Client client = new Client(new Context(), Protocol.HTTPS);
        ClientResource clientResource = new ClientResource(
                "http://localhost:8111/users");
        clientResource.setNext(client);
        //get
        System.out.println(clientResource.get().getText());

        //add
        /*User user1 = new User();
        user1.setName("小明");
        user1.setPassword("bjut");
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
 /*ChallengeResponse authentication = new ChallengeResponse(
                ChallengeScheme.HTTP_BASIC, "huan", "chh912");
        clientResource.setChallengeResponse(authentication);*/
    }
}
