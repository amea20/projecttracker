package com.projecttracker.validation;

public class PasswordValidator {

	public boolean validate(final String password) {
		if (password != null) {
			if 	(!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$")) {
				return false;
			}
		}
		return true;
	}
}
