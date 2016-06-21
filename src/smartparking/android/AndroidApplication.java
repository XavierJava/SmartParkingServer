package smartparking.android;

import smartparking.client.Client;
import smartparking.client.impl.ClientImpl;
import smartparking.model.User;

public class AndroidApplication {
    private Client client;

    public AndroidApplication() {
        client = new ClientImpl();
    }

    public void onButtonAddUserClick() {
        String name = null; // textBoxName.getText();
        String password = null; // textBoxPassword.getText();

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        client.addUser(user);
    }
}
