package com.assignment_1.distributed_systems.flightmanagementsystem.business.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment_1.distributed_systems.flightmanagementsystem.business.entities.Role;
import com.assignment_1.distributed_systems.flightmanagementsystem.business.entities.User;
import com.assignment_1.distributed_systems.flightmanagementsystem.data_access.repositories.RoleRepository;
import com.assignment_1.distributed_systems.flightmanagementsystem.data_access.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void save(User user, String[] userRoles) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> userRolesEntities = new HashSet<Role>();
		for (String userRole : userRoles) {
			userRolesEntities.add(roleRepository.findByName(userRole));
		}
		user.setRoles(userRolesEntities);
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
