package com.jsp.assignment.urlshortener.repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jsp.assignment.urlshortener.entity.ShortURL;
import com.jsp.assignment.urlshortener.entity.User;

@Repository
public class ShortUrlRepository {

	Configuration cfg = new Configuration().configure().addAnnotatedClass(ShortURL.class).addAnnotatedClass(User.class);
	SessionFactory sf = cfg.buildSessionFactory();

	public void saveURL(ShortURL url) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(url);

		transaction.commit();
		session.close();
	}

	public ShortURL findUrlByShortURLKey(String key) {
	    try (Session session = sf.openSession()) {
	        Transaction transaction = session.beginTransaction();

	        Query<ShortURL> query = session.createQuery("FROM ShortURL WHERE shortURLKey=:key", ShortURL.class);
	        query.setParameter("key", key);

	        ShortURL url = null;
	        try {
	            url = query.getSingleResult();
	            transaction.commit();
	        } catch (NoResultException e) {

	            transaction.rollback();
	        }

	        return url;
	    } catch (HibernateException e) {
	        
	        return null;
	    }
	}

	public List<ShortURL> findAllShortURLByUser(User user) {
	    try (Session session = sf.openSession()) {
	        Transaction transaction = session.beginTransaction();

	        Query<ShortURL> query = session.createQuery("FROM ShortURL WHERE user=:user", ShortURL.class);
	        query.setParameter("user", user);

	        List<ShortURL> urls = null;
	        try {
	            urls = query.list();
	            transaction.commit();
	        } catch (HibernateException e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }

	        return urls != null ? urls : Collections.emptyList();
	    } catch (HibernateException e) {
	        return Collections.emptyList();
	    }
	}


	public ShortURL findShortUrlByById(int urlId) {
	    try (Session session = sf.openSession()) {
	        Transaction transaction = session.beginTransaction();

	        ShortURL url = session.get(ShortURL.class, urlId);

	        transaction.commit();
	        return url;
	    } catch (HibernateException e) {       
	        return null; 
	    }
	}


	public void updateURL(ShortURL url) {
	    try (Session session = sf.openSession()) {
	        Transaction transaction = session.beginTransaction();
	        
	        try {
	            session.update(url);
	            transaction.commit();
	        } catch (HibernateException e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	    } catch (HibernateException e) {
	    }
	}

	public void deleteURL(ShortURL url) {
	    try (Session session = sf.openSession()) {
	        Transaction transaction = session.beginTransaction();

	        try {
	            session.delete(url);
	            transaction.commit();
	        } catch (HibernateException e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	    } catch (HibernateException e) {
	    }
	}


}
