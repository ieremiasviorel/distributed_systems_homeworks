package org.assignment_2_2.client.communication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assignment_2_2.client.Client;
import org.assignment_2_2.common.classes.entities.Car;
import org.assignment_2_2.common.classes.serviceinterfaces.ITaxService;

public class TaxValueServiceServlet extends HttpServlet {

	private static final long serialVersionUID = -7505238875102906553L;

	private ITaxService taxService;

	@Override
	public void init() {
		Client.clientInit();
		taxService = Client.getTaxService();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer engineSize = Integer.valueOf(request.getParameter("engineSize"));
		double taxValue = this.taxService.computeTax(new Car(engineSize));
		PrintWriter out = response.getWriter();
		out.println(taxValue);

		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Methods", "GET");
	}
}
