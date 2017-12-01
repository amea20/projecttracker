package com.projecttracker.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.projecttracker.model.Project;
import com.projecttracker.model.User;
import com.projecttracker.service.ProjectService;
import com.projecttracker.validation.ProjectValidator;

@Controller
@SessionAttributes("project")
public class ProjectController {

	private static Logger logger = Logger.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	private ProjectValidator projectValidator;
	
	@InitBinder("project")
	   protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(projectValidator);
	   }
	
	@RequestMapping(method = RequestMethod.GET, value ="/projects")
	public ModelAndView listProjects(@SessionAttribute User user) {
		ModelAndView mv = new ModelAndView("project/projects");
		List<Project> projects = projectService.viewProjects(user.getUserID());
		mv.addObject("projects", projects);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/project/add")
	public ModelAndView addProject(Project project) {
		ModelAndView mv = new ModelAndView("project/add-project");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/project/add")
	public ModelAndView addedProject(@SessionAttribute User user, @Valid @ModelAttribute Project project, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/projects");
		projectService.addProject(project,user);
		if (result.hasErrors()) {
			return new ModelAndView("project/add-project");
		}
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/project/{projectID}/edit")
	public ModelAndView editProject(@PathVariable int projectID, Project project) {
		ModelAndView mv = new ModelAndView("project/edit-project");
		project = projectService.viewProjectByID(projectID);
		mv.addObject("project",project);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/project/{projectID}/edit")
	public ModelAndView updatedProject(@SessionAttribute User user, @Valid @ModelAttribute Project project, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/projects");
		logger.info("Project before update:" + project.toString());
		if (result.hasErrors()) {
			return new ModelAndView("project/edit-project");
		}
		projectService.updateProject(project,user);
		logger.info("Project after update:" + project.toString());
		return mv;
		
	}
	
	
	@ExceptionHandler(value = Exception.class)
    public String handleError(HttpServletRequest req, Exception exception) {
        logger.error("Request: " + req.getRequestURL() + " raised " + exception);
        exception.printStackTrace();
        return "errors/error";
	}
}
