package com.example.bams.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.bams.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getAllUsers() {
		Session ses = entityManager.unwrap(Session.class);
		Query query = ses.createQuery("from User where active=0");
		List<User> results = query.list();
		return results;
	}

	@Override
	public int updateCustomerId(int id, int custid) {
		Session ses = entityManager.unwrap(Session.class);
		Query query = null;
		if (custid != 0) {
			query = ses.createQuery("update User set custid=:custid , active =1 where id=:id");
		} else {
			query = ses.createQuery("update User set custid=:custid , active =-1 where id=:id");
		}

		query.setParameter("custid", custid);
		query.setParameter("id", id);
		return query.executeUpdate();
	}

}
