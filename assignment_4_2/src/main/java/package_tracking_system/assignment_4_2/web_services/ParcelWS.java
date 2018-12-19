package package_tracking_system.assignment_4_2.web_services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import package_tracking_system.assignment_4_2.models.Parcel;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface ParcelWS {

	@WebMethod
	public void saveParcel(@WebParam(name = "parcel") Parcel p);

	@WebMethod
	public void addParcel(@WebParam(name = "name") String name, @WebParam(name = "description") String description,
			@WebParam(name = "senderName") String senderName, @WebParam(name = "receiverName") String receiverName,
			@WebParam(name = "senderCity") String senderCity, @WebParam(name = "receiverCity") String receiverCity);

	@WebMethod
	public Parcel getParcel(@WebParam(name = "parcel_id") Integer id);

	@WebMethod
	public Parcel[] getParcels();
}
