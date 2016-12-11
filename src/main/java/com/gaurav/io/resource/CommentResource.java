package com.gaurav.io.resource;


import com.gaurav.io.Service.CommentService;
import com.gaurav.io.model.Comments;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by oracle on 29/11/16.
 */
@Path("/")

public class CommentResource {

    CommentService cs= new CommentService();
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Comments> getComments(@PathParam("messageId") int id){
        return cs.getComments(id);
    }
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{commentId}")
    public Comments getComment(@PathParam("messageId") int id,@PathParam("commentId") int commentId){
        return cs.getComment(id,commentId);
    }
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Comments addComments(@PathParam("messageId") int id, Comments comment){
        return cs.addComments(id,comment);
    }
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    @Path("/{commentId}")
    public Comments updateComments(@PathParam("messageId") int id, @PathParam("commentId") int commentId, Comments comment){

        return cs.updateComments(id,comment);
    }
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{commentId}")
    @DELETE
    public Comments deleteComment(@PathParam("messageId") int id,@PathParam("commentId") int commentId){
        return cs.deleteComments(id,commentId);
    }
}
