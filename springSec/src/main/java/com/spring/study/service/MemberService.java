package com.spring.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.study.bean.Member;
import com.spring.study.repository.MemberDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("memberService")
public class MemberService {// implements UserDetailsService {
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void test() {
		log.info("test log 출럭");
	}

//	@Override
	public Member loadUserByUsername(String username) throws UsernameNotFoundException {
		Member rMember = new Member();
		rMember.setId(username);
		
		Member member = memberDao.getMemberById(rMember);
		
		if (member == null) {
			throw new UsernameNotFoundException("접속자 정보를 찾을 수 없음");
		}
		
		return member;
	}
	
	public void registerMember(Member member) {
		member.setPw(passwordEncoder.encode(member.getPw()));
		memberDao.insertMember(member);
	}
	
	public List<Member> getAllMember() {
		return memberDao.getAllMember();
	}
}
