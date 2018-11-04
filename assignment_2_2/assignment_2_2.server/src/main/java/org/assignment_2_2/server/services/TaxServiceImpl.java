package org.assignment_2_2.server.services;

import java.rmi.RemoteException;

import org.assignment_2_2.common.classes.entities.Car;
import org.assignment_2_2.common.classes.serviceinterfaces.ITaxService;

public class TaxServiceImpl implements ITaxService {

	public TaxServiceImpl() throws RemoteException {
		super();
	}

	public double computeTax(Car c) {
		if (c.getEngineCapacity() <= 0) {
			throw new IllegalArgumentException("Engine capacity must be positive.");
		}
		int sum = 8;
		if (c.getEngineCapacity() > 1601)
			sum = 18;
		if (c.getEngineCapacity() > 2001)
			sum = 72;
		if (c.getEngineCapacity() > 2601)
			sum = 144;
		if (c.getEngineCapacity() > 3001)
			sum = 290;
		return c.getEngineCapacity() / 200.0 * sum;
	}

//	public static void main(String[] args) {
//		try {
//			Naming.rebind("taxService", new TaxServiceImpl());
//			System.err.println("Server ready");
//
//		} catch (Exception e) {
//			System.err.println("Server exception: " + e.toString());
//			e.printStackTrace();
//		}
//	}
}
