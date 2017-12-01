package com.projecttracker.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.projecttracker.model.User;

@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(method = RequestMethod.GET, value ="/dashboard")
	public ModelAndView dashboard(@SessionAttribute User user) {
		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("user", user);
		return mv;
	}

	@ExceptionHandler(value = Exception.class)
    public String handleError(HttpServletRequest req, Exception exception) {
        logger.error("Request: " + req.getRequestURL() + " raised " + exception);
        exception.printStackTrace();
        return "errors/error";
	}
}
