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
import com.projecttracker.model.Task;
import com.projecttracker.model.User;
import com.projecttracker.service.TaskService;
import com.projecttracker.validation.TaskValidator;

@Controller
@SessionAttributes("task")
public class TaskController {

	private static Logger logger = Logger.getLogger(TaskController.class);
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	private TaskValidator taskValidator;
	
	@InitBinder("task")
	   protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(taskValidator);
	   }
	
	@RequestMapping(method = RequestMethod.GET, value ="/tasks")
	public ModelAndView listTasks(@SessionAttribute User user,@SessionAttribute Project project) {
		ModelAndView mv = new ModelAndView("task/tasks");
		List<Task> tasks = taskService.viewTasks(project);
		mv.addObject("tasks", tasks);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/project/{projectID}/task/add")
	public ModelAndView createTask(@PathVariable int projectID, @ModelAttribute Task task) {
		ModelAndView mv = new ModelAndView("task/create-task");
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/project/{projectID}/task/add")
	public ModelAndView createdTask(@SessionAttribute User user, @SessionAttribute Project project,@Valid @ModelAttribute Task task, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/tasks");
		taskService.createTask(task, project.getProjectID(),user);
		if (result.hasErrors()) {
			return new ModelAndView("task/create-task");
		}
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/project/{projectID}/task/{taskID}/edit")
	public ModelAndView editTask(@PathVariable int projectID,@PathVariable int taskID, Task task) {
		ModelAndView mv = new ModelAndView("task/edit-task");
		task = taskService.viewTaskByID(taskID);
		mv.addObject("task",task);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/project/{projectID}/task/{taskID}/edit")
	public ModelAndView editedTask(@SessionAttribute User user, @Valid @SessionAttribute Project project, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/tasks");
		if (result.hasErrors()) {
			return new ModelAndView("project/edit-task");
		}
		//taskService.updateTask();
		return mv;
		
	}
	
	
	@ExceptionHandler(value = Exception.class)
    public String handleError(HttpServletRequest req, Exception exception) {
        logger.error("Request: " + req.getRequestURL() + " raised " + exception);
        exception.printStackTrace();
        return "errors/error";
	}
}
