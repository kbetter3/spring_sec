package com.spring.study.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.study.bean.Member;
import com.spring.study.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberService memberService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = authentication.getName();
		String pw = (String)authentication.getCredentials();
		
		System.out.println("여긴 언제들어오지?");
		log.info("여기들어와지나?");
		Member member = (Member) memberService.loadUserByUsername(id);
		
		log.info("pw : " + pw);
		log.info("member pw : " + member.getPw());
		
		if (passwordEncoder.matches(pw, member.getPw())) {
			return new UsernamePasswordAuthenticationToken(member, pw, member.getAuthorities());
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
}
