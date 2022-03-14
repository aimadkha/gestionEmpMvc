package com.code.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.code.dao.UserDao;
import com.code.entities.Role;
import com.code.entities.User;



@Service("userService")
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User findId(int id) {
		User user = userDao.findById(id);
		return user;
	}

	@Transactional
	public List<User> finAll() {
		List<User> users = userDao.findAll();
		return users;
	}

	@Transactional
	public void save(User user) {
		userDao.save(user);

	}

	@Transactional
	public void update(User user) {
		userDao.update(user);
	}

	@Transactional
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public boolean login(String user, String pass) {
		System.out.println("from user service");
		if(userDao.checkAdmin(user, pass)) {
			System.out.println("from user service");
			return true;
		}
		return false;
		
	}

	@Transactional
	public List<Role> finAllRoles() {
		List<Role> roles = userDao.findListRole();
		return roles;
	}

}
