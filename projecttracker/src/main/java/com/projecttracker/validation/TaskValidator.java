package com.projecttracker.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.projecttracker.model.Task;

public class TaskValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Task.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Task task = (Task) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskDescription", "task.description.required");
	}

}
