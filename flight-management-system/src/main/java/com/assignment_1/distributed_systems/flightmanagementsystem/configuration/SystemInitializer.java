package com.assignment_1.distributed_systems.flightmanagementsystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment_1.distributed_systems.flightmanagementsystem.business.entities.User;
import com.assignment_1.distributed_systems.flightmanagementsystem.business.services.UserServiceImpl;

@Service
public class SystemInitializer {

	@Autowired
	UserServiceImpl userService;

	public void init() {
		User client = new User("client", "password");
		userService.save(client, new String[] { "CLIENT" });
		User admin = new User("admin", "password");
		userService.save(admin, new String[] { "ADMIN" });
	}
}
