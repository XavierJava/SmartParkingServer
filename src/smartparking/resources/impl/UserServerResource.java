package smartparking.resources.impl;

import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.model.User;
import smartparking.resources.UserResource;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UserServerResource extends ServerResource implements UserResource {
    private String idOrName;
    private String q;

    @Override
    protected void doInit() {
        super.doInit();
        try {
            idOrName = URLDecoder.decode(getAttribute("idOrName"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        q = getQueryValue("q");
    }


    @Override
    public User getUser() {
        if (q.equals("id"))
            return Settings.getUserDao().getUserById(Integer.parseInt(idOrName));
        if (q.equals("name"))
            return Settings.getUserDao().getUserByName(idOrName);
        else return null;
    }


    @Override
    public int removeUser() {
        return Settings.getUserDao().removeUserById(Integer.parseInt(idOrName));
    }
}
