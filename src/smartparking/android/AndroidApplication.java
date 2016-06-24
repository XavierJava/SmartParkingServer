package smartparking.android;

import smartparking.model.User;
import smartparking.rest.UserApi;
import smartparking.rest.impl.UserApiImpl;

public class AndroidApplication {
    private UserApi userApi;

    public AndroidApplication() {
        userApi = new UserApiImpl();
    }

    public void onButtonAddUserClick() {
        String name = null; // textBoxName.getText();
        String password = null; // textBoxPassword.getText();

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        userApi.addUser(user);
    }
}
