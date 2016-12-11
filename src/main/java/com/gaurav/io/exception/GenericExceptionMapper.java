package com.gaurav.io.exception;


import com.gaurav.io.model.Exception;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by oracle on 4/12/16.
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        Exception ex = new Exception(500, exception.getMessage(), "lola");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ex)
                .build();
    }
}
