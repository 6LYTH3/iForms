package com.raiwind.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
}
