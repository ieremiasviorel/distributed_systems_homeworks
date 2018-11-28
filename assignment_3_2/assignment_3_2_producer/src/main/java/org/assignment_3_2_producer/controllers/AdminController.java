package org.assignment_3_2_producer.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.assignment_3_2_common_classes.entity.DVD;
import org.assignment_3_2_producer.communication.QueueCommunication;
import org.assignment_3_2_producer.services.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

	@Autowired
	DVDService dvdService;
	@Autowired
	QueueCommunication queueCommunicationService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("add_dvd");
		return mv;
	}

	@RequestMapping(value = "save-dvd", method = RequestMethod.POST)
	public RedirectView addDVD(HttpServletRequest request, HttpSession session) throws IOException {
		String title = request.getParameter("title");
		Integer year = Integer.valueOf(request.getParameter("year"));
		Double price = Double.valueOf(request.getParameter("price"));

		this.dvdService.addDVD(title, year, price);
		this.queueCommunicationService.publishMessage(new DVD(title, year, price));

		return new RedirectView("/admin");
	}
}
