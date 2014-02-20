package com.sumit.controller;

import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sumit.mongomodel.Task;
import com.sumit.mongorepository.TaskRepository;

@Controller
@RequestMapping(value="/task")
@Slf4j
public class TaskController {
	
	protected static final String JSON_CONTENT = "application/json";
	
	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public ModelAndView sayHello() {
		final ModelAndView mav = new ModelAndView("hello");
		log.debug("inside hello");
		return mav;
	};
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public Task getTask(final @PathVariable String id) {
		final Task task = taskRepository.findOne(id);
		log.debug("task found: {}", task);
		return task;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public List<Task> listTasks() {
		final List<Task> tasks = taskRepository.findAll();
		log.debug("total count of tasks found: {}", tasks.size());
		return tasks;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.PUT, produces = JSON_CONTENT)
	@ResponseBody
	public Task createTask(@RequestBody final Task task) {
		log.debug("creating task: {}", task);
		taskRepository.save(task);
		return task;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces = JSON_CONTENT)
	@ResponseBody
	public Task updateTask(@RequestBody final Task task) {
		log.debug("updating task: {}", task);
		taskRepository.save(task);
		return task;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public HashMap<String, Boolean> deleteTask(@PathVariable final String id) {
		
		log.debug("deleting task with id: {}", id);
		final HashMap<String, Boolean> result = new HashMap<>(); 
		
		try {
			taskRepository.delete(id);
			result.put("result", Boolean.TRUE);
		} catch (Exception e) {
			result.put("result", Boolean.FALSE);
		}
		return result;
	}	
}
