package com.sumit.controller;

import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumit.mongomodel.User;
import com.sumit.mongorepository.UserRepository;

@Controller
@RequestMapping(value="/user")
@Slf4j
public class UserController {
	
	protected static final String JSON_CONTENT = "application/json";
	
	@Autowired(required=true)
	UserRepository userRepository;

	@RequestMapping(value="/list", method=RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public List<User> listUsers() {
		final List<User> users = userRepository.findAll();
		log.debug("total count of users found: {}", users.size());
		return users;
	}

	@RequestMapping(value="/create", method=RequestMethod.PUT, produces = JSON_CONTENT)
	@ResponseBody
	public User createUser(@RequestBody final User user) {
		log.debug("creating task: {}",  user);
		userRepository.save(user);
		return user;
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public HashMap<String, Boolean> deleteUser(@PathVariable final String id) {
		log.debug("deleting task with id: {}", id);
		final HashMap<String, Boolean> result = new HashMap<>(); 
		
		try {
			userRepository.delete(id);
			result.put("result", Boolean.TRUE);
		} catch (Exception e) {
			result.put("result", Boolean.FALSE);
		}
		return result;
	}
}
