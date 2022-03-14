package com.code.services;

import java.util.List;

import com.code.entities.Role;
import com.code.entities.User;


public interface UserService {

	List<User> finAll();

	User findId(int id);

	void save(User user);

	void update(User user);

	void delete(int id);

	boolean login(String user, String pass);
	
	List<Role> finAllRoles();

}
