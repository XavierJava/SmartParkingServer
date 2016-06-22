package smartparking.resources.impl;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.model.User;
import smartparking.resources.common.UserResource;

public class UserServerResource extends ServerResource implements UserResource {
    private String userId;

    @Override
    protected void doInit() {
        super.doInit();

        userId = getAttribute("userId");
    }

    @Override
    public Representation getUser() {
        if (userId == null || !userId.matches("^[0-9]*[1-9][0-9]*$"))
            return new StringRepresentation("参数类型错误");

        User user = Settings.getUserDao().getUserById(Integer.parseInt(userId));

        return user == null ? new StringRepresentation("不存在该用户", MediaType.TEXT_PLAIN) :
                new JacksonRepresentation<User>(user);
    }


    @Override
    public String removeUser() {
        if (userId == null || !userId.matches("^[0-9]*[1-9][0-9]*$"))
            return "参数类型错误";

        return Settings.getUserDao().removeUserById(Integer.parseInt(userId)) > 0 ? "删除成功" : "删除失败";
    }

}
