package com.gaurav.io.database;



import com.gaurav.io.model.Message;
import com.gaurav.io.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oracle on 27/11/16.
 */
public class DatabaseClass {
    private static Map<Integer,Message> messages= new HashMap<>();
    private static Map<String,Profile> profiles= new HashMap<>();


    public static Map<Integer, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }


}

