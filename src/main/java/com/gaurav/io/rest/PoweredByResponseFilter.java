package com.gaurav.io.rest;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by oracle on 11/12/16.
 */
@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter, ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        responseContext.getHeaders().add("X-Powered-By", "Gaurav");
        System.out.println("Response header "+ responseContext.getHeaders());
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("request header "+ requestContext.getHeaders());
    }
}
