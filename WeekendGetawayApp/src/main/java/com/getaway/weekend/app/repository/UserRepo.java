package com.getaway.weekend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.getaway.weekend.app.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByEmail(String email);
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User getUserByEmail(@Param("email") String email);

}
