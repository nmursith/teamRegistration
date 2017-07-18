package com.virtusa.teamvirtusa.entities;

import javax.persistence.*;

/**
 * Created by delegate on 7/12/17.
 */

@Entity
@Table(name = "team_details")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    int teamId;

    @Column(name = "team_name", nullable = false)
    String teamName;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
