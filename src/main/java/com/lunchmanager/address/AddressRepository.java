package com.lunchmanager.address;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends CrudRepository <Address, Long> {
	
	@Query("SELECT a FROM Address a WHERE a.id=:id")
	public Address findByAddressId(@Param("id") Long id);

}
