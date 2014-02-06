package com.sumit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sumit.mongorepository.TaskRepository;
import com.sumit.mongorepository.UserRepository;

@Controller
@Slf4j
@RequestMapping(value="")
public class SecurityController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskRepository taskRepository;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		log.debug("inside login");
		return new ModelAndView("login");
	}

	@RequestMapping(value="/accessdenied", method=RequestMethod.GET)
	public ModelAndView accessdenied() {
		log.debug("inside accessdenied");
		return new ModelAndView("common/accessdenied");
	}

   @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	   SecurityContextHolder.clearContext();	   
	   return "redirect:/login";
    }
   
	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public ModelAndView index() {
		
//		final Task task = new Task();
//		task.setName("task");
//		task.setPriority(Priority.HIGH);
//		task.setStatus(Status.PENDING);
//		task.setCreated(new Date());
//		task.setDescription("description");
//		task.setDueDate(new Date());
//		taskRepository.save(task);
//		
//		List<Task> tasks = new ArrayList<Task>();
//		tasks.add(task);
//		tasks.add(task);
//		tasks.add(task);
//		
//		final User u = new User();
//		u.setFirstName("sumit");
//		u.setFirstName("arora");
//		u.setTasks(tasks);
//		
//		userRepository.save(u);
		return new ModelAndView("index");
	}
	
}
