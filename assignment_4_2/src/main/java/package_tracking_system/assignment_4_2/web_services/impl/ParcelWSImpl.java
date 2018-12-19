package package_tracking_system.assignment_4_2.web_services.impl;

import javax.jws.WebService;

import package_tracking_system.assignment_4_2.models.City;
import package_tracking_system.assignment_4_2.models.Delivery;
import package_tracking_system.assignment_4_2.models.Parcel;
import package_tracking_system.assignment_4_2.models.User;
import package_tracking_system.assignment_4_2.services.CityService;
import package_tracking_system.assignment_4_2.services.ParcelService;
import package_tracking_system.assignment_4_2.services.UserService;
import package_tracking_system.assignment_4_2.services.impl.CityServiceImpl;
import package_tracking_system.assignment_4_2.services.impl.ParcelServiceImpl;
import package_tracking_system.assignment_4_2.services.impl.UserServiceImpl;
import package_tracking_system.assignment_4_2.web_services.ParcelWS;

@WebService(endpointInterface = "package_tracking_system.assignment_4_2.web_services.ParcelWS")
public class ParcelWSImpl implements ParcelWS {

	private ParcelService parcelService = new ParcelServiceImpl();
	private CityService cityService = new CityServiceImpl();
	private UserService userService = new UserServiceImpl();

	@Override
	public void saveParcel(Parcel p) {
		this.parcelService.add(p);
	}
	
	@Override
	public void addParcel(String name, String description, String senderName, String receiverName, String senderCity,
			String receiverCity) {
		City parcelSenderCity = this.cityService.getCityByName(senderCity);
		City parcelReceiverCity = this.cityService.getCityByName(receiverCity);
		
		Delivery delivery = new Delivery();
		delivery.setOriginCity(parcelSenderCity);
		delivery.setDestinationCity(parcelReceiverCity);
		delivery.setTracked(true);
	
		User sender = this.userService.getUserByUsername(senderName);
		User receiver = this.userService.getUserByUsername(receiverName);
		
		Parcel parcel = new Parcel();
		parcel.setName(name);
		parcel.setDescription(description);
		parcel.setSender(sender);
		parcel.setReceiver(receiver);
		parcel.setDelivery(delivery);
		
		parcelService.add(parcel);
	}
	
	@Override
	public Parcel getParcel(Integer id) {
		return this.parcelService.getById(id);
	}

	@Override
	public Parcel[] getParcels() {
		return this.parcelService.getAll().toArray(new Parcel[0]);
	}
}
