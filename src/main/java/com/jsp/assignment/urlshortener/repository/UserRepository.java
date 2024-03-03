package com.jsp.assignment.urlshortener.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jsp.assignment.urlshortener.entity.User;

@Repository
public class UserRepository {

	Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class);
	SessionFactory sf = cfg.buildSessionFactory();

	public void saveUser(User user) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(user);

		transaction.commit();
		session.close();
	}

	public User findById(int userId) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class, userId);

		transaction.commit();
		session.close();

		return user;
	}

	public User findByEmail(String email) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Query<User> query = session.createQuery("FROM User WHERE email=:email", User.class);
		query.setParameter("email", email);
		User user = query.uniqueResult();

		transaction.commit();
		session.close();

		return user;
	}

}
