package com.projecttracker.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "USERS")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int userID;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="DOB")
	private Date DOB;
	
	@Column(name="EMAILADDRESS")
	private String emailAddress;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(name="ADDRESS_1")
	private String address1;
	
	@Column(name="ADDRESS_2")
	private String address2;
	
	@Column(name="ADDRESS_3")
	private String address3;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="POSTCODE")
	private String postcode;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Enumerated(EnumType.STRING)
	@Column(name="USER_TYPE")
	private UserType userType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="USER_ROLE")
	private UserRole userRole;
	
	//approved or rejected
	@Column(name="STATE")
	private String state;
	
	//awaiting_approval, reset password, available, disabled, locked
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DATE_CREATED")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateCreated;
	
	@Column(name="DATE_MODIFIED")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateModified;
	
	@Column(name="LOCKED")
	private boolean locked;
	
	@Column(name="DISABLED")
	private boolean disabled;
	
	@Column(name="NUM_ATTEMPTS")
	private int loginAttempts;
	
	@Column(name="LOGGEDIN_DATETIME")
	private LocalDateTime loggedinDatetime;
	
	@Column(name="LOGGEDOUT_DATETIME")
	private LocalDateTime loggedoutDatetime;
	
	public User() {
		
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public LocalDateTime getLoggedinDatetime() {
		return loggedinDatetime;
	}

	public void setLoggedinDatetime(LocalDateTime loggedinDatetime) {
		this.loggedinDatetime = loggedinDatetime;
	}

	public LocalDateTime getLoggedoutDatetime() {
		return loggedoutDatetime;
	}

	public void setLoggedoutDatetime(LocalDateTime loggedoutDatetime) {
		this.loggedoutDatetime = loggedoutDatetime;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", DOB=" + DOB + ", emailAddress=" + emailAddress + ", password=" + password
				+ ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", city=" + city
				+ ", postcode=" + postcode + ", country=" + country + ", userType=" + userType + ", userRole="
				+ userRole + ", state=" + state + ", status=" + status + ", dateCreated=" + dateCreated
				+ ", dateModified=" + dateModified + ", locked=" + locked + ", disabled=" + disabled
				+ ", loginAttempts=" + loginAttempts + ", loggedinDatetime=" + loggedinDatetime + ", loggedoutDatetime="
				+ loggedoutDatetime + "]";
	}
	
		
	
}