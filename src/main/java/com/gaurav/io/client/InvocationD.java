package com.gaurav.io.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by oracle on 11/12/16.
 */
public class InvocationD {
    public static void main(String[] args) {
        InvocationD invocationD= new InvocationD();
        Invocation invocation=invocationD.prepareRequestForMesByYear(2016);
        Response response = invocation.invoke();
        System.out.println(response.getStatus());
    }

    private javax.ws.rs.client.Invocation prepareRequestForMesByYear(int year) {
        Client client = ClientBuilder.newClient();
        return client.target("http://localhost:8080/webapi/")
                .path("messages")
                .queryParam("year",year)
                .request(MediaType.APPLICATION_JSON)
                .buildGet();

    }
}
