package com.gaurav.io.resource;


import com.gaurav.io.Service.MessageService;
import com.gaurav.io.model.Message;
import com.gaurav.io.bean.MessageFilterBean;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created by oracle on 26/11/16.
 */
@Path("/messages")
public class MessageResource {
    MessageService m = new MessageService();

    @GET
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public List<Message> getAllMssg(@BeanParam MessageFilterBean messageFilterBean) {
        if (messageFilterBean.getYear() > 0)
            return m.getAllMessagesByYear(messageFilterBean.getYear());
        if (messageFilterBean.getSize() > 0 && messageFilterBean.getStart() > 0)
            return m.getAllMessagePaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
        return m.getAllMessage();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(Message msg, @Context UriInfo uriInfo) {
        Message newMsg=m.addMessage(msg);
        String newId= String.valueOf(newMsg.getMessageId());
        URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newMsg)
                .build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") int id, Message msg) {
        msg.setMessageId(id);
        return m.updateMessage(msg);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public void deleteMsg(@PathParam("messageId") int id) {
        m.deleteMessage(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") int messageId, @Context UriInfo uriInfo) {
        if (messageId <= 0) return null;
        Message msg= m.getMessage(messageId);
       /* String s = getUriForSelf(uriInfo, msg);
        String uriForProfile = getUriForProfile(uriInfo, msg);
        String uriForComments = getUriForComments(uriInfo, msg);
        msg.addLinks(s,"self");
        msg.addLinks(uriForProfile,"profile");
        msg.addLinks(uriForComments,"comments1");*/
        return msg;
    }

    private String getUriForSelf(@Context UriInfo uriInfo, Message msg) {
        return uriInfo.getBaseUriBuilder()
                    .path(MessageResource.class)
                    .path(Integer.toString(msg.getMessageId()))
                    .build().toString();
    }
    private String getUriForProfile(@Context UriInfo uriInfo, Message msg) {
        return uriInfo.getBaseUriBuilder()
                .path(ProfileResource.class)
                .path(msg.getAuthor())
                .build().toString();
    }
    private String getUriForComments(@Context UriInfo uriInfo, Message msg) {
        return uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(MessageResource.class,"callCommentResource")
                .path(CommentResource.class)
                .resolveTemplate("messageId",msg.getMessageId())
                .build().toString();
    }

    @Path("/{messageId}/{comments}")
    public CommentResource callCommentResource(){
        return new CommentResource();
    }

}