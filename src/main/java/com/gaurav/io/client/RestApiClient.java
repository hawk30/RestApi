package com.gaurav.io.client;

import com.gaurav.io.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by oracle on 11/12/16.
 */
public class RestApiClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget baseTarget = client.target("http://localhost:8080/webapi/");
        WebTarget messageTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messageTarget.path("{messageId}");
        Message message1 = singleMessageTarget.resolveTemplate("messageId", 1)
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        Message message2 = singleMessageTarget.resolveTemplate("messageId", 2)
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        Message message3 = singleMessageTarget.resolveTemplate("messageId", 3)
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        System.out.println(message1.getMessage());
        System.out.println(message2.getMessage());
        System.out.println(message3.getMessage());

        Message message= new Message(4,"4th msg from jax-rs client", "gaurav", new Date());
        Response postMessage
                = messageTarget
                .request()
                .post(Entity.json(message));
        Message createdMessage = postMessage.readEntity(Message.class);
        System.out.println(createdMessage.getMessage());

    }
}

