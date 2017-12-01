package com.projecttracker.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttracker.dao.UtilityDAO;
import com.projecttracker.model.User;

@Repository("utilityDAO")
public class UtilityDAOImpl implements UtilityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int getUserIDByUsername(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select id from User where username= :username");
		query.setParameter("username", username);
		if (query.uniqueResult() != null) {
			int userID = ((Integer) query.uniqueResult()).intValue();
			return userID;
		}
		return -1;
	}
    
	public User selectUser(int userId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where userID= :userID");
		query.setParameter("userID", userId);
		if (query.list().size() != 0) {
			User user = (User)query.list().get(0);
			return user;
			}
			return null;
	}
	
	public User selectUser(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username= :username");
		query.setParameter("username", username);
		if (query.list().size() != 0) {
		User user = (User)query.list().get(0);
		return user;
		}
		return null;
	}
	
	public User selectUser(String username,String password) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username= :username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		if (query.list().size() != 0) {
			User user = (User)query.list().get(0);
			return user;
		}
			return null;
	}
	
	public User selectUserResetPassword(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username= :username and status= 'RESET PASSWORD'");
		query.setParameter("username", username);
		if (query.list().size() != 0) {
			User user = (User)query.list().get(0);
			return user;
			}
			return null;
	}
	
	public int updateUser(int userId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update User set dateModified=:datemodified where userID =:userID");
		query.setParameter("userID", userId);
		query.setParameter("datemodified", new Date());
		query.executeUpdate();
		return 1;
	}
	
	public int updatepassword(String username,String newPassword) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update User set password=:password,status= 'AVAILABLE',dateModified=:datemodified where username =:username");
		query.setParameter("username", username);
		query.setParameter("password", newPassword);
		query.setParameter("datemodified", new Date());
		query.executeUpdate();
		return 1;
	}
	
	public void deleteUser(int userId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update User set status= 'DISABLED',dateModified=:datemodified where userID =:userID");
		query.setParameter("userID", userId);
		query.setParameter("datemodified", new Date());
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,String> getCountries() {
		Map<String,String> countriesMap = new TreeMap<>();
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT country_name,country_code FROM countries");
		List<Object[]> countries = query.list();
		for (Object[] country:countries) {
			countriesMap.put(country[0].toString(), country[1].toString());
		}
		
		return countriesMap;
	}

	public String generateUsername(String firstname, String lastname) {
		String username = firstname.toLowerCase().substring(0, 1) + lastname.toLowerCase();
		Session session = sessionFactory.openSession();
		Query query	= session.createQuery("from User where username LIKE :username order by username DESC");
		query.setParameter("username", username + "%");
		query.setMaxResults(1);
		if (query.list().size() != 0) {
			User user = (User) query.list().get(0);
			if (user.getUsername().equals(username)) {
				return username + "1";
			}
		int sequence = Integer.parseInt(user.getUsername().substring(username.length()));
		username = firstname.toLowerCase().charAt(0) + lastname.toLowerCase() + ++sequence;
		}
		return username;
	}
	
	public String generateTempPass() {
			Random random = new Random();
			String upperCase ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
			String numbers = "0123456789";
			String specialChars = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
			char [] tempPass = new char[11];
			for (int i=0;i<tempPass.length;i++) {
			switch(random.nextInt(3)) {
			case(0): tempPass[i] = upperCase.charAt(random.nextInt(upperCase.length()));
			break;
	        case(1): tempPass[i] = lowerCase.charAt(random.nextInt(lowerCase.length()));
			break;
			case(2): tempPass[i] = numbers.charAt(random.nextInt(numbers.length()));
			break;
			case(3): tempPass[i] = specialChars.charAt(random.nextInt(specialChars.length()));
			break;
			}
	        }
	    	return String.valueOf(tempPass);
	}
}
