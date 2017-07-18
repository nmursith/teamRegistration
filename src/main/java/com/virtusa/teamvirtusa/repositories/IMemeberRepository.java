package com.virtusa.teamvirtusa.repositories;

import com.virtusa.teamvirtusa.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by delegate on 7/12/17.
 */
@Repository
public interface IMemeberRepository extends CrudRepository<Member, Integer> {
    @Query(value="SELECT m FROM Member m where m.emailAddress = ?1")
    Member findMemberByEmail(String email);

    @Query(value="SELECT m FROM Member m where m.team.teamName = ?1")
    List<Member> findMembersByName(String name);

}
