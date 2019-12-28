/**
 * nasru
 * MyUserDetails.java
 * Dec 18, 2019
 */
package com.mypractice.hrms.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mypractice.hrms.model.User;

/**
 * @author nasru
 *
 */

public class MyUserDetails implements UserDetails {

	private Collection<? extends GrantedAuthority> authorities;
	private String username;
	private String password;
	/*private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	private boolean enabled;*/



	/**
	 * @param user 
	 * 
	 */
	public MyUserDetails(User user) {

		List<GrantedAuthority> grantedAuths  = new ArrayList<GrantedAuthority>();
		grantedAuths.add((GrantedAuthority) new SimpleGrantedAuthority("user.getUserRole().getRoleName()"));
		this.authorities =grantedAuths;
		this.username = user.getEmail();
		this.password=user.getPassword();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public MyUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
