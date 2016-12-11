package com.gaurav.io.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by oracle on 27/11/16.
 */
@XmlRootElement
public class Profile {
    int id;
    String profileName;
    String firstName;
    String lastName;
    Date created;

    public Profile() {
    }

    public Profile(int id, String profileName, String firstName, String lastName, Date created) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
