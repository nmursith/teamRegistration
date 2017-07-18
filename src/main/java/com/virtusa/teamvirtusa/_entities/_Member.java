package com.virtusa.teamvirtusa._entities;

/**
 * Created by delegate on 7/12/17.
 */
public class _Member {
    private  String name;
    private  String emailAddress;
    private boolean isLeader;

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
