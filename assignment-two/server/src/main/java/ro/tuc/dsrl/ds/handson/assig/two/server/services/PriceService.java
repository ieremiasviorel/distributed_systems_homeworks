package ro.tuc.dsrl.ds.handson.assig.two.server.services;

import java.util.Calendar;

import ro.tuc.dsrl.ds.handson.assig.two.common.entities.Car;
import ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces.IPriceService;

public class PriceService implements IPriceService {

	@Override
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
