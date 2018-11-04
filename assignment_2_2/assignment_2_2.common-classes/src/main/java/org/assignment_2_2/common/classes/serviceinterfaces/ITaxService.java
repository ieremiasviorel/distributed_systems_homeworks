package org.assignment_2_2.common.classes.serviceinterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.assignment_2_2.common.classes.entities.Car;

public interface ITaxService extends Remote {

	double computeTax(Car c) throws RemoteException;
}
