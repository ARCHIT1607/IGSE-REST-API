package com.iGSE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iGSE.entity.Customer;
import com.iGSE.entity.UserDetailsImpl;
import com.iGSE.repository.CustomerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private CustomerRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("email "+email);
		Customer user=userRepo.findByEmail(email);
		
		System.out.println("inside impl "+user);
		
		if(user==null) {
			System.out.println("exception thrown");
			throw new UsernameNotFoundException(email + "not found");
		}
		return new UserDetailsImpl(user);
	}

}
