package com.projecttracker.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

	private FilterConfig filterConfig = null;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	public void destroy() {
		this.filterConfig = null;
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login";
        String registerURI = request.getContextPath() + "/register";
        String registerConfirmURI = request.getContextPath() + "/registration-confirmation";
        String forgottenURI = request.getContextPath() + "/forgot-password";
        String resourcesURI = request.getContextPath() + "/resources";
        String emailWS = request.getContextPath() + "/emailaddress";
		if (filterConfig == null) {
			return;
		}
		else {
			boolean loggedIn = session != null && session.getAttribute("username") != null;
	        boolean loginRequest = request.getRequestURI().equals(loginURI);
	        boolean resources = request.getRequestURI().startsWith(resourcesURI);
	        boolean register = request.getRequestURI().equals(registerURI);
	        boolean forgotten = request.getRequestURI().equals(forgottenURI);
	        boolean registerConfirm = request.getRequestURI().equals(registerConfirmURI);
	        boolean email = request.getRequestURI().equals(emailWS);
			if (loggedIn || loginRequest || resources 
					|| forgotten || register || registerConfirm || email) {
				chain.doFilter(request, response);
			}
			else {
				response.sendRedirect(loginURI);
			}
			
			
		}

	}

}
