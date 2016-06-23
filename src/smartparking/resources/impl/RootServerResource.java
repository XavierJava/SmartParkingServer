package smartparking.resources.impl;

import org.restlet.resource.ServerResource;
import smartparking.resources.common.RootResource;

public class RootServerResource extends ServerResource implements RootResource {
    public String represent() {
        return "Welcome to " + getApplication().getName() + "!";
    }
}
