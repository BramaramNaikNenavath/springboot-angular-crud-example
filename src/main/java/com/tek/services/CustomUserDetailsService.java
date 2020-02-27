package com.tek.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tek.models.CustomUserDetails;
import com.tek.models.Users;
import com.tek.repository.LoginRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
		System.out.println(">>>>>>>>>>>> Invoked CustomUserDetailsService loadUserByUsername() >>>>>>>>>>> "+userName);
		Optional<Users> optionalUsers = loginRepository.findByName(userName);
		if(optionalUsers.isPresent()) {
			new UsernameNotFoundException("Username not found");
		}
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
