/**
 * ParcelWSImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package package_tracking_system.assignment_4_2.web_services.impl;

public class ParcelWSImplServiceLocator extends org.apache.axis.client.Service implements package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImplService {

    public ParcelWSImplServiceLocator() {
    }


    public ParcelWSImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ParcelWSImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ParcelWSImpl
    private java.lang.String ParcelWSImpl_address = "http://localhost:8080/assignment_4_2/services/ParcelWSImpl";

    public java.lang.String getParcelWSImplAddress() {
        return ParcelWSImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ParcelWSImplWSDDServiceName = "ParcelWSImpl";

    public java.lang.String getParcelWSImplWSDDServiceName() {
        return ParcelWSImplWSDDServiceName;
    }

    public void setParcelWSImplWSDDServiceName(java.lang.String name) {
        ParcelWSImplWSDDServiceName = name;
    }

    public package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl getParcelWSImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ParcelWSImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getParcelWSImpl(endpoint);
    }

    public package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl getParcelWSImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImplSoapBindingStub _stub = new package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getParcelWSImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setParcelWSImplEndpointAddress(java.lang.String address) {
        ParcelWSImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImplSoapBindingStub _stub = new package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImplSoapBindingStub(new java.net.URL(ParcelWSImpl_address), this);
                _stub.setPortName(getParcelWSImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ParcelWSImpl".equals(inputPortName)) {
            return getParcelWSImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.web_services.assignment_4_2.package_tracking_system", "ParcelWSImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.web_services.assignment_4_2.package_tracking_system", "ParcelWSImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ParcelWSImpl".equals(portName)) {
            setParcelWSImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
