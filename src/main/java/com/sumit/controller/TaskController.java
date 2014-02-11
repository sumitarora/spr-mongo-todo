package com.sumit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sumit.mongomodel.Task;
import com.sumit.mongorepository.TaskRepository;

@Controller
@RequestMapping(value="/task")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView listTasks() {
		final List<Task> tasks = taskRepository.findAll();
		System.out.println(tasks.size());
		
		ModelAndView mav = new ModelAndView("task/list", "allTasks", tasks);
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createTask() {
		ModelAndView mav = new ModelAndView("task/create", "task", new Task());
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveTask(HttpServletRequest request) {
		System.out.println(request.getAttribute("taskName"));
		ModelAndView mav = new ModelAndView("task/create", "task", new Task());
		return mav;
	}
}
