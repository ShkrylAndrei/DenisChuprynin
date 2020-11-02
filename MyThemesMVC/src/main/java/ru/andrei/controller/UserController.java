package ru.andrei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value="/str", method = RequestMethod.GET)
	public String useForm(){
		return "test";
	}

}