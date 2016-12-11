package com.gaurav.io.Service;

import com.gaurav.io.database.DatabaseClass;
import com.gaurav.io.model.Comments;
import com.gaurav.io.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by oracle on 29/11/16.
 */
public class CommentService {
    Map<Integer,Message> messages= DatabaseClass.getMessages();

    public List<Comments> getComments(int messageId){
        Map<Integer,Comments> comments= messages.get(messageId).getComments();
        comments.put(1,new Comments(1,"1st comment","gaurav", new Date()));
        return new ArrayList<>(comments.values());
    }

    public Comments getComment(int messageId, int commentId){
        Map<Integer,Comments> comments= messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public Comments addComments(int messageId, Comments comment){
        Map<Integer,Comments> comments= messages.get(messageId).getComments();
        comment.setCommentId(comments.size()+1);
        return comments.put(comment.getCommentId(),comment);
    }

    public Comments updateComments(int messageId, Comments comment){
        Map<Integer,Comments> comments= messages.get(messageId).getComments();
        if(comment.getCommentId()<=0) return null;
        return comments.put(comment.getCommentId(), comment);
    }

    public Comments deleteComments(int messageId, int commentId){
        Map<Integer,Comments> comments=messages.get(messageId).getComments();
        return comments.remove(commentId);
    }

}
