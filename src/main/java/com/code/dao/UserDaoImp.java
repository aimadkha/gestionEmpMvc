package com.code.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.code.entities.Role;
import com.code.entities.User;

@Repository

public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		List<User> users = null;
		Session session = sessionFactory.getCurrentSession();
		users = session.createQuery("from User").list();
		return users;
	}

	@Override
	public User findById(int id) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		user = session.get(User.class, id);
		return user;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		user = session.get(User.class, id);
		session.delete(user);
	}

	@Override
	public boolean checkAdmin(String email, String password) {
		User user = null;
		Session session = sessionFactory.openSession();
		user = (User) session.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email)
				.uniqueResult();
		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findListRole() {
		List<Role> roles = null;
		Session session = sessionFactory.getCurrentSession();
		roles = session.createQuery("from Role").list();
		return roles;
	}

}
