package com.gaurav.io.exception;


import com.gaurav.io.model.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by oracle on 4/12/16.
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException exception) {
        Exception ex= new Exception(404,exception.getMessage(),"lol");

        return Response.status(Response.Status.NOT_FOUND)
                .entity(ex)
                .build();
    }
}
