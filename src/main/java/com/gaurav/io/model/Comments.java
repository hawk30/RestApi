package com.gaurav.io.model;

import java.util.Date;

/**
 * Created by oracle on 29/11/16.
 */
public class Comments {
    private int commentId;
    private String comment;
    private String author;
    private Date created;

    public Comments() {
    }

    public Comments(int commentId, String comment, String author, Date created) {
        this.commentId = commentId;
        this.comment = comment;
        this.author = author;
        this.created = created;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
