package com.gaurav.io.client;

import com.gaurav.io.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by oracle on 11/12/16.
 */
public class GenericT {
    public static void main(String[] args) {
        Client client= ClientBuilder.newClient();
        List<Message> messages = client.target("http://localhost:8080/webapi/")
                .path("messages")
                .queryParam("year", 2016)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>() {
                });
        System.out.println(messages);

    }
}
