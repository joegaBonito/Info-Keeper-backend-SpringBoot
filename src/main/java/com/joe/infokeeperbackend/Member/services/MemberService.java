package com.joe.infokeeperbackend.Member.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.joe.infokeeperbackend.Member.domain.Member;

public interface MemberService {
	public List<Member> list();
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	public void save(Member member);
}
