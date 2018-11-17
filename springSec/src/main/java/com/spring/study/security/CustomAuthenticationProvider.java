package com.spring.study.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.study.bean.Member;
import com.spring.study.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = authentication.getName();
		String pw = (String) authentication.getCredentials();
		
		log.info("memberService : " + memberService);
		
//		Member member = null;
//		
//		try {
//			member = memberService.loadUserByUsername(id);
//			
//			log.info("provider - member : " + member);
//			
//			if (!passwordEncoder.matches(pw, member.getPw())) {
//				throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
//			}
//		} catch (UsernameNotFoundException e) {
//			log.info(e.toString());
//			throw new UsernameNotFoundException(e.getMessage());
//		} catch (BadCredentialsException e) {
//			log.info("BadCredentialException" + e.toString());
//			throw new BadCredentialsException(e.getMessage());
//		} catch (Exception e) {
//			log.info(e.toString());
//			throw new RuntimeException(e.getMessage());
//		}
		
		Member member = memberService.loadUserByUsername(id);
			
		log.info("provider - member : " + member);
		
		if (!passwordEncoder.matches(pw, member.getPw())) {
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword(), member.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
