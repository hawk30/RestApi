package com.gaurav.io.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by oracle on 7/12/16.
 */
@Path("date/{dateParam}")
public class DateResource {

    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getDate(@PathParam("dateParam") MyDate dateInfo){
        return "date is: "+dateInfo.toString();
    }*/

    @GET
    @Produces(value = {MediaType.TEXT_PLAIN,"text/shortDate"})
    public Date testMethod(){
        return Calendar.getInstance().getTime();
    }



}

