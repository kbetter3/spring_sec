package com.spring.study.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.study.bean.Member;
import com.spring.study.repository.MemberDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("memberService")
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member reqMember = new Member();
		reqMember.setId(username);
		
		log.info("dao : " + memberDao);
		
		Member member = memberDao.getMemberById(reqMember);
		
		if (member == null) {
			throw new UsernameNotFoundException("No user found with username : " + username);
		}
		
		return member;
	}
}
