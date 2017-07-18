package com.virtusa.teamvirtusa.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delegate on 7/12/17.
 */
public class TeamDetails {

//    private  Team team;
    private List<Member> members;

    public TeamDetails(){
        members = new ArrayList<>();

    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }


}
