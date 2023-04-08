package com.getaway.weekend.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.getaway.weekend.app.entity.Destination;

@Repository
public interface DestinationRepo extends JpaRepository<Destination, Long>{
	
	@Transactional
	@Modifying
	@Query("delete from Destination d where d.id like ?1 and file_name like ?2")
	public void deleteDestinationWithFile(Long id,String file_name);

}
