package com.virtusa.teamvirtusa.services;

import com.virtusa.teamvirtusa._entities._Email;
import com.virtusa.teamvirtusa._entities._Member;
import com.virtusa.teamvirtusa._entities._TeamRegister;
import com.virtusa.teamvirtusa.entities.Member;
import com.virtusa.teamvirtusa.entities.Team;
import com.virtusa.teamvirtusa.entities.TeamDetails;
import com.virtusa.teamvirtusa.repositories.IMemeberRepository;
import com.virtusa.teamvirtusa.repositories.ITeamRepository;
import com.virtusa.teamvirtusa.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by delegate on 7/12/17.
 */
@Service
public class TeamServices {
    @Autowired
    private IMemeberRepository memeberRepository;

    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private ValidationUtils validationUtils;

    @Transactional
    public TeamDetails createTeam(_TeamRegister teamRegister){

        Team team = new Team();
        TeamDetails teamDetails = new TeamDetails();

        if(teamRegister.getTeamName() == null )
            throw new RuntimeException("Team name is not valid");

        if(checkDuplicateTeam(teamRegister.getTeamName())){
            throw new RuntimeException("Team name: "+teamRegister.getTeamName()+ " already exists");
        }

        if(teamRegister.getTeamMembers().size()>4){
            throw new RuntimeException("Team can have atmost 4 Memebers");
        }


        team.setTeamName(teamRegister.getTeamName());
        team = teamRepository.save(team);

        int countLeader=0;
        for (_Member member: teamRegister.getTeamMembers()) {
            Member resMember;

            if(member!=null && !member.getEmailAddress().equals("")) {

                resMember = new Member(member.getName(), member.getEmailAddress(), member.isLeader(), team);

                if(checkDuplicateEmail(member.getEmailAddress())){
                    throw new RuntimeException("The email address "+member.getEmailAddress()+ " already exists");
                }


                resMember = memeberRepository.save(resMember);
                teamDetails.getMembers().add(resMember);
                if(member.isLeader())
                    countLeader++;

            }
            else {
                return null;
            }


        }


        if(countLeader>1 || countLeader==0){
            throw new RuntimeException("Team doesn't have a leader");

        }
     /*   if(teamRegister.getTeamLeader()== null) {
            return null;
        }
        else {
            Member teamLeader = new Member(teamRegister.getTeamLeader().getName(), teamRegister.getTeamLeader().getEmailAddress(), true, team);

            if(checkDuplicateEmail(teamRegister.getTeamLeader().getEmailAddress())){
                return null;
            }

            teamLeader = memeberRepository.save(teamLeader);
            teamDetails.getMembers().add(teamLeader);
        }




        if(addMember(teamRegister.getTeamMember2(), team, teamDetails) == null)
            return null;


        if(addMember(teamRegister.getTeamMember3(), team, teamDetails) == null)
            return null;


        if(addMember(teamRegister.getTeamMember4(), team, teamDetails) == null)
            return null;*/



        return teamDetails ;
    }

    @Transactional
    public Member addMember(_Member member, Team team, TeamDetails teamDetails){
        Member resMember;

        if(member!=null) {
            resMember = new Member(member.getName(), member.getEmailAddress(), false, team);

            if(checkDuplicateEmail(member.getEmailAddress())){
                return null;
            }

            resMember = memeberRepository.save(resMember);
            teamDetails.getMembers().add(resMember);
        }
        else {
            return null;
        }
        return resMember;

    }
    @Transactional
    public boolean checkDuplicateEmail(String email) {

            if (memeberRepository.findMemberByEmail(email) != null) {
                // if member already exist or wrong email;
                throw new RuntimeException("Member is already registered");

            } else if (!validationUtils.validateVirtusaEmailId(email)) {
                throw new RuntimeException("Enter valid email address "+ email);
            } else
                return false;



    }


    @Transactional
    public boolean checkDuplicateTeam(String teamName) {

        if(teamRepository.findMemberByName(teamName) !=null  ) {
            // if member already exist or wrong email;
            throw new RuntimeException("Team name: "+teamName+" is not available");
        }
        else
            return false;
    }
    @Transactional
    public List<Member> getTeam(String name) {

       return memeberRepository.findMembersByName(name);

    }
}
