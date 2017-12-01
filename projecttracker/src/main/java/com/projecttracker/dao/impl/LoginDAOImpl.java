package com.projecttracker.dao.impl;

import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttracker.dao.LoginDAO;
import com.projecttracker.dao.UtilityDAO;
import com.projecttracker.model.User;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Autowired
    UtilityDAO utilityDAO;
	
	public User checkCredentials(String username, String password) {
			User user = utilityDAO.selectUser(username,password);
			if (user != null && user.getStatus().equals("AVAILABLE")) {
				return user;
			}
				return null;
	}
	
	public int checkPassword(String username, String newPassword) {
			User user= utilityDAO.selectUserResetPassword(username);
			if (user != null && !user.isDisabled() && !user.isLocked()) {
			int results = utilityDAO.updatepassword(username, newPassword);
			if (results > 0) {
			return 0;
			}
			return -1;
			}
		return -1;
	}
	
	public boolean checkEmailExists(String emailAddress) {
			boolean userExists = false;
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from User where emailAddress =:emailAddress");
			query.setParameter("emailAddress", emailAddress);
			if (query.list().size() != 0) {
			User user = (User) query.list().get(0);
			if (!user.getEmailAddress().isEmpty()) {
			userExists = true;
			}
			}
		return userExists;
	}
	
	public boolean checkUserCredentials(String username, String password) {
		User userResults = checkCredentials(username,password);
		if (userResults != null) {
			return true;
		}
		return false;
	}
	
	public int loginFailed(String username) {
		int userId = utilityDAO.getUserIDByUsername(username);
		if (userId > 0) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, userId);
		if (user.getLoginAttempts() == 2) {
			loginAttemptExceeded(username);
			return -1;
		}
		Query query = session.createQuery("update User set loginAttempts= :loginAttempts,dateModified=:datemodified where userID=:userID");
		query.setParameter("loginAttempts", user.getLoginAttempts()+1);
		query.setParameter("datemodified", new Date());
		query.setParameter("userID", userId);
		query.executeUpdate();
		return 1;
		}
		return 0;
	}
	
	public void loginAttemptExceeded(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update User set status= 'LOCKED',locked = '1',dateModified=:datemodified where username=:username and loginAttempts =2");
		query.setParameter("datemodified", new Date());
		query.setParameter("username", username);
		query.executeUpdate();
	}
	
}
