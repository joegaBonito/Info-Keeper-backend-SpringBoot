package com.joe.infokeeperbackend.Member.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joe.infokeeperbackend.Member.domain.Member;


@Repository
public interface MemberRepository extends CrudRepository<Member,Long> {

	List<Member> findAllByOrderByEmail();

	Member findByEmail(String username);

}
