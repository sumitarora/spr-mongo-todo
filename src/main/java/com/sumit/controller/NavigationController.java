package com.sumit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sumit.mongomodel.User;
import com.sumit.mongorepository.UserRepository;

@Controller
public class NavigationController {

	@Autowired
	private UserRepository repository;
	
	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public ModelAndView index() {
		
		final User u = new User();
		u.setFirstName("sumit");
		u.setFirstName("arora");
		
		repository.save(u);
		return new ModelAndView("index");
	}
	
}
