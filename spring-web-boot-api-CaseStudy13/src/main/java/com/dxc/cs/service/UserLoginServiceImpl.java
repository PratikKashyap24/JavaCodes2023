package com.dxc.cs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dxc.cs.entity.UserLogin;
import com.dxc.cs.repository.UserLoginRepository;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

	@Autowired
	private UserLoginRepository repo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (!repo.existsById(username)) {
			throw new UsernameNotFoundException("No such user found");
		}

		UserLogin userLogin = repo.findById(username).orElse(null);

		return new User(userLogin.getUserName(), userLogin.getEnPassword(), new ArrayList<>());

	}

	public UserLogin save(UserLogin user) {
		user.setEnPassword(encoder.encode(user.getPassword()));
		return repo.saveAndFlush(user);

	}

	public boolean findById(String userName) {
		if (repo.existsById(userName)) {
			return true;
		}
		return false;

	}
	
	public UserLogin getById(String userName) {
		UserLogin user=repo.findById(userName).orElse(null);
		if(user!=null) {
			return user;
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	
}
