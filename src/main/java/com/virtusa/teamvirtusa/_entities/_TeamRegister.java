package com.virtusa.teamvirtusa._entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delegate on 7/12/17.
 */
public class _TeamRegister {
    private String teamName;
/*    private _Member teamLeader;
    private _Member teamMember2;
    private _Member teamMember3;
    private _Member teamMember4;*/
    private List<_Member> teamMembers = new ArrayList<>();




    public List<_Member> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<_Member> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String temamName) {
        this.teamName = temamName;
    }
}
