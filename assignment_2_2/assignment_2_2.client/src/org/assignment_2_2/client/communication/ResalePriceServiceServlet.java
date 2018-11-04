package org.assignment_2_2.client.communication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assignment_2_2.client.Client;
import org.assignment_2_2.common.classes.entities.Car;
import org.assignment_2_2.common.classes.serviceinterfaces.IPriceService;

public class ResalePriceServiceServlet extends HttpServlet {

	private static final long serialVersionUID = 7313252146826242986L;

	private IPriceService priceService;

	@Override
	public void init() {
		Client.clientInit();
		priceService = Client.getPriceService();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double purchasePrice = Double.valueOf(request.getParameter("purchasePrice"));
		Integer productionYear = Integer.valueOf(request.getParameter("productionYear"));
		double resalePrice = this.priceService.computeSellingPrice(new Car(productionYear, purchasePrice));
		PrintWriter out = response.getWriter();
		out.println(resalePrice);
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Methods", "GET");
	}
}
