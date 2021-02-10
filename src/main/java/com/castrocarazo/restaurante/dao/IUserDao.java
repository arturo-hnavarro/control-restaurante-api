package com.castrocarazo.restaurante.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.castrocarazo.restaurante.domain.User;

public interface IUserDao extends CrudRepository<User, Long>{
	
	List<User> findByUsernameAndPassword(String username, String password);	
}
