package com.gaurav.io.Service;

import com.gaurav.io.database.DatabaseClass;
import com.gaurav.io.exception.DataNotFoundException;
import com.gaurav.io.model.Message;

import java.util.*;

/**
 * Created by oracle on 26/11/16.
 */
public class MessageService {

    private Map<Integer, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1, new Message(1, "my 1st message..hurray", "gv", new Date()));
        messages.put(2, new Message(2, "2nd message: rest api client..hum", "gv", new Date()));
        messages.put(3, new Message(3, "3rd message: it's fucking awesome", "gv", new Date()));
    }

    public List<Message> getAllMessage() {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesByYear(int year) {
        List<Message> messageForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Message msg : messages.values()) {
            cal.setTime(msg.getCreated());
            if (cal.get(Calendar.YEAR) == year)
                messageForYear.add(msg);
        }
        return messageForYear;
    }

    public List<Message> getAllMessagePaginated(int start, int size) {
        ArrayList<Message> list = new ArrayList<>(messages.values());
        if (start + size > list.size())
            return new ArrayList<Message>();
        return list.subList(start, start + size);

    }

    public Message getMessage(int id) {
        Message msg = messages.get(id);
        if (msg == null)
            throw new DataNotFoundException("message with id: " + id + " not found");
        else
            return msg;
    }

    public Message updateMessage(Message msg) {
        if (msg.getMessageId() <= 0)
            return null;
        messages.put(msg.getMessageId(), msg);
        return msg;
    }

    public Message addMessage(Message msg) {
        msg.setMessageId(messages.size() + 1);
        messages.put(msg.getMessageId(), msg);
        return msg;
    }

    public void deleteMessage(int id) {
        if (id <= 0)
            return;
        messages.remove(id);

    }

}
