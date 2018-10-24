package com.flight_management_system.business_logic.services;

import com.flight_management_system.business_logic.entities.User;
import com.flight_management_system.data_access.repositories.UserRepository;

public class UserServiceImpl {

	private UserRepository userRepository;

	public UserServiceImpl() {
		this.userRepository = new UserRepository();
	}

	public User findForAuthentication(String username, String password) {
		return this.userRepository.findByUsernameAndPassword(username, password);
	}
}
