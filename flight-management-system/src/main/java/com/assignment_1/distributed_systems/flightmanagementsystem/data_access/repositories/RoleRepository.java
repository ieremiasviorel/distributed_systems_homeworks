package com.assignment_1.distributed_systems.flightmanagementsystem.data_access.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment_1.distributed_systems.flightmanagementsystem.business.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(String name);
}
