package com.projecttracker.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projecttracker.model.User;
import com.projecttracker.service.UserService;
import com.projecttracker.service.UtilityService;
import com.projecttracker.validation.UserValidator;

@Controller
public class RegisterController {

	private static Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	private UtilityService utilityService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@InitBinder
	   protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(userValidator);
	   }
	
	@RequestMapping(method = RequestMethod.GET, value ="/register")
	public ModelAndView register(User user) {
		ModelAndView mv = new ModelAndView("register");
		Map<String,String> countriesMap = utilityService.getCountries();
		mv.addObject("user",user);
		mv.addObject("countries", countriesMap);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/register")
	public ModelAndView register(HttpServletRequest request, @Valid User user,BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:registration-confirmation");
		Map<String,String> countriesMap = utilityService.getCountries();
		if (result.hasErrors()) {
			mv = new ModelAndView("register");
			mv.addObject("countries", countriesMap);
			return mv;
		}
		userService.createUser(user);
		logger.info("User: " + user.getUsername());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/registration-confirmation")
	public ModelAndView registrationConfirmation(User user) {
		ModelAndView mv = new ModelAndView("registration-confirmation");
		return mv;
	}
	
	@ExceptionHandler(value = Exception.class)
    public String handleError(HttpServletRequest req, Exception exception) {
        logger.error("Request: " + req.getRequestURL() + " raised " + exception);
        exception.printStackTrace();
        return "errors/error";
	}
}
