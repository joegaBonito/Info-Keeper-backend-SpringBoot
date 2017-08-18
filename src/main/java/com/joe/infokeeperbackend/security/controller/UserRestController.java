package com.joe.infokeeperbackend.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joe.infokeeperbackend.Member.domain.Member;
import com.joe.infokeeperbackend.Member.services.MemberService;
import com.joe.infokeeperbackend.security.JwtAuthenticationRequest;
import com.joe.infokeeperbackend.security.JwtTokenUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRestController {
    
    @Autowired
    private MemberService memberService;
    
    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        Member member = new Member();
        member.setEmail(authenticationRequest.getUsername());
        member.setPassword(authenticationRequest.getPassword());
        memberService.save(member);
		return ResponseEntity.ok(null);
    }

}
