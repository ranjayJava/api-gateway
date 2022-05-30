package com.org.service;

import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.model.Role;
import com.org.model.User;
import com.org.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User saveUser(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		user.setCreateTime(LocalDateTime.now());
		
		return userRepository.save(user);
	}
	
	 @Override
	    public Optional<User> findByUsername(String username)
	    {
	        return userRepository.findByUsername(username);
	    }

	    @Override
	    @Transactional //Transactional is required when executing an update/delete query.
	    public void changeRole(Role newRole, String username)
	    {
	        userRepository.updateUserRole(username, newRole);
	    }
}
