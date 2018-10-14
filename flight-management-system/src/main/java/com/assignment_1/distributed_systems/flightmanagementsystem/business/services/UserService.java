package com.assignment_1.distributed_systems.flightmanagementsystem.business.services;

import com.assignment_1.distributed_systems.flightmanagementsystem.business.entities.User;

public interface UserService {

	void save(User user);
	
	void save(User user, String[] userRoles);

	User findByUsername(String username);
}
