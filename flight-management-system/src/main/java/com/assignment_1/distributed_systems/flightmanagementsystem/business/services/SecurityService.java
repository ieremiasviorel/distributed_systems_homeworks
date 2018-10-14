package com.assignment_1.distributed_systems.flightmanagementsystem.business.services;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

	void logout();
}
