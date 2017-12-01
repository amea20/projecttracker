package com.projecttracker.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.projecttracker.model.User;

public class UserValidator implements Validator {

	@Autowired
	private EmailValidator emailValidator;
	@Autowired
	private PasswordValidator passwordValidator;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DOB", "dob.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "emailaddress.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "password.confirm");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "country.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "address1.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postcode", "postcode.required");
		
		User user = (User)target;
		
		if (!(emailValidator.validate(user.getEmailAddress())) && !(user.getEmailAddress().isEmpty())) {
			errors.rejectValue("emailAddress", "invalid.email");
		}
		
		if (!(passwordValidator.validate(user.getPassword())) && !(user.getPassword().isEmpty())) {
			errors.rejectValue("password", "invalid.password");
		}
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.reject("password.unmatched");
		}
	}

	
}
