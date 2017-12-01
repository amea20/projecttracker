package com.projecttracker.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttracker.model.User;
import com.projecttracker.model.UserType;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UtilityDAO utilityDAO;
	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		user.setUsername(utilityDAO.generateUsername(user.getFirstName(), user.getLastName()));
		user.setFirstName(user.getFirstName());
		user.setLastName(user.getFirstName());
		user.setDOB(user.getDOB());
		user.setEmailAddress(user.getEmailAddress());
		user.setPassword(user.getPassword());
		user.setCountry(user.getCountry());
		user.setAddress1(user.getAddress1());
		user.setAddress2(user.getAddress2());
		user.setAddress3(user.getAddress3());
		user.setCity(user.getCity());
		user.setPostcode(user.getPostcode());
		user.setDateCreated(new Date());
		user.setDateModified(new Date());
		user.setUserType(UserType.USER);
		user.setStatus("AWAITING_APPROVAL");
		session.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> viewDashboard(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("CALL viewDashboard()");
		List<String> results = query.list();
		return results;
	}

	@Override
	public void viewChangeLog(String username) {
		

	}

	@Override
	public void updateUser(User user) {
		

	}
}
