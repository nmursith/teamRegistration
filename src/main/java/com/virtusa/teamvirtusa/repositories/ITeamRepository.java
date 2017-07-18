package com.virtusa.teamvirtusa.repositories;

import com.virtusa.teamvirtusa.entities.Member;
import com.virtusa.teamvirtusa.entities.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by delegate on 7/12/17.
 */

@Repository
public interface ITeamRepository extends CrudRepository<Team, Integer>{

    @Query(value="SELECT t FROM Team t where t.teamName = ?1")
    Team findMemberByName(String teamName);
}
