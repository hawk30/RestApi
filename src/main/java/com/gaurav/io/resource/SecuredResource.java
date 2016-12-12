package com.gaurav.io.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by oracle on 11/12/16.
 */
@Path("secured")
public class SecuredResource {

    @GET
    @Path("/messages")
    @Produces(MediaType.TEXT_PLAIN)
    public String securedMethod(){
        return "I'm secured";
    }
}
