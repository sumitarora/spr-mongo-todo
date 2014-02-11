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
	public String index() {
		return "redirect:/task/list";
	}
	
}
