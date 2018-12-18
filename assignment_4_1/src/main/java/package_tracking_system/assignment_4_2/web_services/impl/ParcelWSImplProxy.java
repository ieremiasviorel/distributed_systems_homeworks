package package_tracking_system.assignment_4_2.web_services.impl;

public class ParcelWSImplProxy implements package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl {
  private String _endpoint = null;
  private package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl parcelWSImpl = null;
  
  public ParcelWSImplProxy() {
    _initParcelWSImplProxy();
  }
  
  public ParcelWSImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initParcelWSImplProxy();
  }
  
  private void _initParcelWSImplProxy() {
    try {
      parcelWSImpl = (new package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImplServiceLocator()).getParcelWSImpl();
      if (parcelWSImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)parcelWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)parcelWSImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (parcelWSImpl != null)
      ((javax.xml.rpc.Stub)parcelWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl getParcelWSImpl() {
    if (parcelWSImpl == null)
      _initParcelWSImplProxy();
    return parcelWSImpl;
  }
  
  public void addParcel(package_tracking_system.assignment_4_2.models.Parcel p) throws java.rmi.RemoteException{
    if (parcelWSImpl == null)
      _initParcelWSImplProxy();
    parcelWSImpl.addParcel(p);
  }
  
  public package_tracking_system.assignment_4_2.models.Parcel[] getParcels() throws java.rmi.RemoteException{
    if (parcelWSImpl == null)
      _initParcelWSImplProxy();
    return parcelWSImpl.getParcels();
  }
  
  public package_tracking_system.assignment_4_2.models.Parcel getParcel(int id) throws java.rmi.RemoteException{
    if (parcelWSImpl == null)
      _initParcelWSImplProxy();
    return parcelWSImpl.getParcel(id);
  }
  
  
}