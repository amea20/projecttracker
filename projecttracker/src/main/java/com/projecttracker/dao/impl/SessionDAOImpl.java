package com.projecttracker.dao.impl;

import java.time.LocalDateTime;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttracker.dao.SessionDAO;

@Repository("sessionDAO")
public class SessionDAOImpl implements SessionDAO {

	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public int createSession(String username) {
					Session hibernateSession = sessionFactory.openSession();
					Query query = hibernateSession.createQuery("update User set loggedinDatetime= :loggedindatetime,loginAttempts=0 where username= :username");
					query.setParameter("username", username);
					query.setParameter("loggedindatetime", LocalDateTime.now());
					int result = query.executeUpdate();
					if (result == 1) {
					return 1;
					}
					return -1;
		}

	@Override
	public void closeSession(String username) {
		Session hibernateSession = sessionFactory.openSession();
		Query query = hibernateSession.createQuery("update User set loggedoutDatetime= :loggedoutdatetime where username= :username");
		query.setParameter("username", username);
		query.setParameter("loggedoutdatetime", LocalDateTime.now());
		query.executeUpdate();
	}

}
