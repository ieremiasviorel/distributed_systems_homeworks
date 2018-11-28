package org.assignment_3_2_producer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.assignment_3_2_common_classes.entity.DVD;
import org.assignment_3_2_producer.services.DVDService;
import org.assignment_3_2_producer.services.NewsletterSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "")
public class ClientController {

	@Autowired
	DVDService dvdService;
	@Autowired
	NewsletterSubscriptionService newsletterService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpSession session) {
		List<DVD> dvds = dvdService.getAllDVDs();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("dvds", dvds);
		return mv;
	}

	@RequestMapping(value = "subscribe", method = RequestMethod.POST)
	public RedirectView subscribe(HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		this.newsletterService.subscribe(email);
		return new RedirectView("/");
	}
}
