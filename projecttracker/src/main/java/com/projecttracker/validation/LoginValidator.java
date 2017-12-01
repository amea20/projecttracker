package com.projecttracker.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.projecttracker.dao.UtilityDAO;
import com.projecttracker.model.User;

public class LoginValidator implements Validator{

	@Autowired
	private UtilityDAO utilityDAO;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		
		User user = (User) target;
		
		
		if (!user.getUsername().isEmpty() && !user.getPassword().isEmpty()) {
			User selectedUser = utilityDAO.selectUser(user.getUsername(),user.getPassword());
				
				if (selectedUser != null){
					//Validate state if not empty
					if (selectedUser.getState() != null) {
						if (selectedUser.getState().equals("REJECTED")) {
							errors.reject("account.rejected");
						}
					}
					//Validate status if not empty
					if (selectedUser.getStatus() != null) {
					
						switch(selectedUser.getStatus()) {
						case "LOCKED": errors.reject("account.locked");
						break;
						case "DISABLED": errors.reject("account.disabled");
						break;
						case "AWAITING_APPROVAL": errors.reject("account.awaiting.approval");
						break;
						}
					}
				}
		}

	}
}