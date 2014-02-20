package com.sumit.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sumit.mongomodel.User;
import com.sumit.mongorepository.TaskRepository;
import com.sumit.mongorepository.UserRepository;

@Controller
@Slf4j
@RequestMapping(value="/security")
public class SecurityController {
	
	protected static final String JSON_CONTENT = "application/json";
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskRepository taskRepository;

	@RequestMapping(value="/login", method=RequestMethod.POST, produces = JSON_CONTENT)
	@ResponseBody
	public HashMap<String, Object> loginUser(@RequestBody User user) {
		log.debug("inside login email: {}", user.getEmail());
		final HashMap<String, Object> result = new HashMap<String, Object>();
		final List<User> users = userRepository.findByEmail(user.getEmail());
		if(users.size() == 0) {
			result.put("result", "failure");
			result.put("response", "No user found with specified email address.");
			return result;
		}
		result.put("result", "success");
		result.put("response", users.get(0));
		return result;
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
	public String index() {
		return "redirect:/task/list";
	}
	
}
