package smartparking.verifer;

import org.restlet.security.SecretVerifier;
import smartparking.api.Api;
import smartparking.api.ApiImpl;
import smartparking.dao.UserDaoImpl;

/**
 * Created by chenhuanhuan on 16-6-3.
 */
public class LoginVerifier extends SecretVerifier {
    private Api api;

    public LoginVerifier(UserDaoImpl dao) {
        this.api = new ApiImpl(dao);
    }

    @Override
    public int verify(String s, char[] chars) {
        int flag = -1;
        String pswd = new String(chars);
        System.out.println("account:" + s + "--password:" + pswd);
        try {
            if (api.login(s, pswd))
                flag = RESULT_VALID;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
