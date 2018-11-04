package org.assignment_2_2.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.assignment_2_2.common.classes.serviceinterfaces.IPriceService;
import org.assignment_2_2.common.classes.serviceinterfaces.ITaxService;

public class Client {

	public static ITaxService taxServiceStub;
	public static IPriceService priceServiceStub;

	public static void clientInit() {
		if (taxServiceStub == null || priceServiceStub == null) {
			try {
				Registry registry = LocateRegistry.getRegistry(1099);

				taxServiceStub = (ITaxService) registry.lookup("taxService");
				priceServiceStub = (IPriceService) registry.lookup("priceService");

			} catch (Exception e) {
				System.err.println("Client exception: " + e.toString());
				e.printStackTrace();
			}
		}
	}

	public static ITaxService getTaxService() {
		return taxServiceStub;
	}

	public static IPriceService getPriceService() {
		return priceServiceStub;
	}
}