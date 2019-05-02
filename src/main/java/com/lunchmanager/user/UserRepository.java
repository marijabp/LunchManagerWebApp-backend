package com.lunchmanager.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	public List<RequiredUserInfo> findAllProjetedBy();
	public User findByEmail(String email);
	public User findUserById (Long id);

	
	
}
