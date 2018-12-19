/**
 * ParcelWSImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package package_tracking_system.assignment_4_2.web_services.impl;

public interface ParcelWSImpl extends java.rmi.Remote {
    public void saveParcel(package_tracking_system.assignment_4_2.models.Parcel p) throws java.rmi.RemoteException;
    public void addParcel(java.lang.String name, java.lang.String description, java.lang.String senderName, java.lang.String receiverName, java.lang.String senderCity, java.lang.String receiverCity) throws java.rmi.RemoteException;
    public package_tracking_system.assignment_4_2.models.Parcel getParcel(int id) throws java.rmi.RemoteException;
    public package_tracking_system.assignment_4_2.models.Parcel[] getParcels() throws java.rmi.RemoteException;
}
