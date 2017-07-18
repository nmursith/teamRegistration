package com.virtusa.teamvirtusa.controllers;

import com.virtusa.teamvirtusa._entities.OK;
import com.virtusa.teamvirtusa._entities._Email;
import com.virtusa.teamvirtusa._entities._TeamRegister;
import com.virtusa.teamvirtusa.entities.Member;
import com.virtusa.teamvirtusa.entities.Team;
import com.virtusa.teamvirtusa.entities.TeamDetails;
import com.virtusa.teamvirtusa.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by delegate on 7/12/17.
 */
@RestController
public class TeamController {

    @Autowired
    private TeamServices teamServices;

    @RequestMapping(method = RequestMethod.POST, value="/createTeam")
    public ResponseEntity<TeamDetails> createTeam(@RequestBody _TeamRegister teamRegister){

        TeamDetails teamDetails = teamServices.createTeam(teamRegister);

        if(teamDetails == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(teamDetails);
    }

    @RequestMapping(method = RequestMethod.GET, value="/checkDuplicateEmail/{email:.+}")
    public ResponseEntity<OK> checkDuplicateEmail(@PathVariable String email){

        Boolean aBoolean= teamServices.checkDuplicateEmail(email);

//        if(!aBoolean){
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }

        return ResponseEntity.ok(new OK(aBoolean));
    }

    @RequestMapping(method = RequestMethod.GET, value="/getTeamDetails/{name:.+}")
    public ResponseEntity<List<Member>> getTeamByName(@PathVariable String name){

        List<Member> team= teamServices.getTeam(name);
//
//        if(team ==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
        return ResponseEntity.ok(team);
    }

    @RequestMapping(method = RequestMethod.GET, value="/checkDuplicateTeam/{name:.+}")
    public ResponseEntity<Boolean> checkDuplicateTeam(@PathVariable String name){

        Boolean team= teamServices.checkDuplicateTeam(name);

//        if(!team){
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }

        return ResponseEntity.ok(team);
    }
}
