package org.assignment_2_2.server.communication;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.assignment_2_2.common.classes.serviceinterfaces.IPriceService;
import org.assignment_2_2.common.classes.serviceinterfaces.ITaxService;
import org.assignment_2_2.server.services.PriceServiceImpl;
import org.assignment_2_2.server.services.TaxServiceImpl;

public class Server {

	public static void main(String args[]) {
		try {
			// Registry registry = LocateRegistry.getRegistry();

			TaxServiceImpl taxServiceObj = new TaxServiceImpl();
			PriceServiceImpl priceServiceObj = new PriceServiceImpl();

			ITaxService taxServiceStub = (ITaxService) UnicastRemoteObject.exportObject(taxServiceObj, 0);
			IPriceService priceServiceStub = (IPriceService) UnicastRemoteObject.exportObject(priceServiceObj, 0);

			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("taxService", taxServiceStub);
			registry.bind("priceService", priceServiceStub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}