package com.gaurav.io.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by oracle on 29/11/16.
 */
@Path("/injectDemo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnnotationDemoResource {
    @GET
    @Path("annotations")
    public String getMatriparam(@MatrixParam("matrix") int value, @HeaderParam("authenticationToken") String token, @CookieParam("name") String cookie){
        return "matrix param: "+ value+ "header param: "+token+ " Cookie "+cookie;
    }

    @GET
    @Path("context")
    public String getContextParam(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
        return "path: "+ uriInfo.getAbsolutePath().toString()+" headers: "+httpHeaders.getAcceptableMediaTypes().toString();
    }
}

