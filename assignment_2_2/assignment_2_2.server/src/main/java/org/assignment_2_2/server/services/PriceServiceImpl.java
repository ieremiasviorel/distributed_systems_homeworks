package org.assignment_2_2.server.services;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.assignment_2_2.common.classes.entities.Car;
import org.assignment_2_2.common.classes.serviceinterfaces.IPriceService;

public class PriceServiceImpl implements IPriceService {

	public PriceServiceImpl() throws RemoteException {
		super();
	}

	public double computeSellingPrice(Car c) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		if (currentYear - c.getYear() < 7) {
			double purchasePrice = c.getPrice();
			return purchasePrice - purchasePrice / 7 * (currentYear - c.getYear());
		} else {
			return 0;
		}
	}
}
