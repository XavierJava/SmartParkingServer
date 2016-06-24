package smartparking.android;

import smartparking.api.UserApi;
import smartparking.api.impl.UserApiImpl;
import smartparking.model.User;

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
