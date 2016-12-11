package com.gaurav.io.Service;



import com.gaurav.io.database.DatabaseClass;
import com.gaurav.io.model.Profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by oracle on 28/11/16.
 */
public class ProfileService {

    Map<String, Profile> profiles= DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("gaurav", new Profile(1,"gaurav1292","gaurav", "singh", new Date()));
        profiles.put("aryan", new Profile(2,"aryan1292","aryan", "singh", new Date()));
    }
    public List<Profile> getAllProfiles(){
        return new ArrayList<>(profiles.values());
    }
    public Profile getProfile(String name){
        return profiles.get(name);
    }
    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        return profiles.put(profile.getProfileName(),profile);
    }
    public Profile deleteProfile(String name){

        return profiles.remove(name);
    }
    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty())
            return null;
        return profiles.put(profile.getProfileName(), profile);
    }

}
