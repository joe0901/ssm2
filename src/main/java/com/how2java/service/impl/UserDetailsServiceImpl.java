/*package com.how2java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UserDetailsServiceImpl implements UserDetailsService {



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> grantAuths = new ArrayList();
		grantAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		*//**
		 * User:
		 * * 参数：
		 * 	* 1.用户名
		 *  * 2.密码
		 *  * 3.认证信息（角色）
		 *//*
		// 去数据库进行查询:
		TbSeller seller = sellerService.findOne(username);
		if(seller != null){
			if(seller.getStatus().equals("1")){
				return new User(username,seller.getPassword(),grantAuths );
			}else{
				return null;
			}
		}
		List<GrantedAuthority> grantAuths = new ArrayList<GrantedAuthority>();
		grantAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return new User(username,"$2a$10$3lKZtBjF.T.asRwiz9NSmO7A2mNivf9emH2abErKZFrVEp.hs0jmO",grantAuths );
		
	}
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encode = passwordEncoder.encode("1234");
		System.out.println(encode);
	}
}
*/