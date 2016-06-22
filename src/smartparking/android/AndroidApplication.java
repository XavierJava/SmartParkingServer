package smartparking.android;

import smartparking.API.UserApi;
import smartparking.API.m.UserImpl;
import smartparking.model.User;

public class AndroidApplication {
    private UserApi client;

    public AndroidApplication() {
        client = new UserImpl();
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
