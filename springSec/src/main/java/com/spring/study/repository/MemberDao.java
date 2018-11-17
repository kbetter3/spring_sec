package com.spring.study.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.study.bean.Member;

@Repository("memberDao")
public class MemberDao {
	@Autowired
	private SqlSession session;
	
	public Member test() {
		return session.selectOne("MemberMapper.test");
	}
	
	public Member getMemberById(Member member) {
		return session.selectOne("MemberMapper.getMemberById", member);
	}
	
	public void insertMember(Member member) {
		session.insert("MemberMapper.insertMember", member);
	}
}
