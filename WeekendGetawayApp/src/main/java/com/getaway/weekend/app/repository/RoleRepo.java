package com.getaway.weekend.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.getaway.weekend.app.dto.RoleDto;
import com.getaway.weekend.app.entity.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
	Role findByRole(String type);
	

}
