package com.spring.study.bean;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class Member implements UserDetails {
	private Integer seq;
	private String id;
	private String pw;
	private String name;
	private Integer power;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		switch (this.power) {
		case 1:
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		case 0:
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			break;
		}
		
		return authorities;
	}
	@Override
	public String getPassword() {
		return this.pw;
	}
	@Override
	public String getUsername() {
		return this.id;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
