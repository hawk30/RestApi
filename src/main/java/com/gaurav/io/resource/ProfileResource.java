package com.gaurav.io.resource;


import com.gaurav.io.Service.ProfileService;
import com.gaurav.io.model.Profile;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by oracle on 28/11/16.
 */
@Path("/profiles")
public class ProfileResource {
    ProfileService p = new ProfileService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAllProfiles(){
        return p.getAllProfiles();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Profile getProfile(@PathParam("name") String name){
        return p.getProfile(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile){
        return p.addProfile(profile);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Profile updateProfile(@PathParam("name") String name, Profile profile){
        profile.setProfileName(name);
        return  p.updateProfile(profile);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Profile deleteProfile(@PathParam("name") String name){

        return p.deleteProfile(name);
    }


}
