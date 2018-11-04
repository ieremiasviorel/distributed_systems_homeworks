package org.assignment_2_2.common.classes.serviceinterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.assignment_2_2.common.classes.entities.Car;

public interface IPriceService extends Remote {

	double computeSellingPrice(Car c) throws RemoteException;
}
