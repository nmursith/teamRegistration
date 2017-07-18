package com.virtusa.teamvirtusa.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by delegate on 7/12/17.
 */
@Entity
@Table(name = "team_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false)
    private Team team;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "leader", nullable = false, columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean leader;

    public Member() {
    }

    public Member(String name, String emailAddress, boolean leader, Team team) {
        this.team = team;
        this.name = name;
        this.emailAddress = emailAddress;
        this.leader = leader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }
}
