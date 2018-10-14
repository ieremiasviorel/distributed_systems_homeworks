package com.assignment_1.distributed_systems.flightmanagementsystem.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("admin-home");
	}
}
