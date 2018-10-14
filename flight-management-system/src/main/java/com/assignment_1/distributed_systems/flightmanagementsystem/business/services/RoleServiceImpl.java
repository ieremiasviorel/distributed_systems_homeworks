package com.assignment_1.distributed_systems.flightmanagementsystem.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment_1.distributed_systems.flightmanagementsystem.business.entities.Role;
import com.assignment_1.distributed_systems.flightmanagementsystem.data_access.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role get(String roleName) {
		return this.roleRepository.findByName(roleName);
	}
}
