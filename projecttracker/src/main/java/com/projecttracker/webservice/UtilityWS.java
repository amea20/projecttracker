package com.projecttracker.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projecttracker.service.LoginService;

@RestController
public class UtilityWS {

	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/emailaddress") 
	public String checkEmail(@RequestParam String emailAddress) {
		if (loginService.checkEmailExists(emailAddress)) {
			return emailAddress;
		}
		return "";
	}
}
