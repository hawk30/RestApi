package com.gaurav.io.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

/**
 * Created by oracle on 26/11/16.
 */
@XmlRootElement
public class Message {
    private int messageId;
    private String message;
    private String author;
    private Date created;

    private Map<Integer, Comments> comments = new HashMap<>();
    private List<Link> links= new ArrayList<>();

    public Message() {
    }

    public Message(int messageId, String message, String author, Date created) {
        this.messageId = messageId;
        this.message = message;
        this.author = author;
        this.created = created;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    @XmlTransient
    public Map<Integer, Comments> getComments() {
        return comments;
    }

    public void setComments(Map<Integer, Comments> comments) {
        this.comments = comments;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    public void addLinks(String url, String rel){
        Link link= new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }
}
