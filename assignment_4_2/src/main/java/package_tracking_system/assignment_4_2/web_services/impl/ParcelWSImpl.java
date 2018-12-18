package package_tracking_system.assignment_4_2.web_services.impl;

import javax.jws.WebService;

import package_tracking_system.assignment_4_2.models.Parcel;
import package_tracking_system.assignment_4_2.services.ParcelService;
import package_tracking_system.assignment_4_2.services.impl.ParcelServiceImpl;
import package_tracking_system.assignment_4_2.web_services.ParcelWS;

@WebService(endpointInterface = "package_tracking_system.assignment_4_2.web_services.ParcelWS")
public class ParcelWSImpl implements ParcelWS {

	private ParcelService packageService = new ParcelServiceImpl();

	@Override
	public void addParcel(Parcel p) {
		this.packageService.add(p);
	}

	@Override
	public Parcel getParcel(Integer id) {
		return this.packageService.getById(id);
	}

	@Override
	public Parcel[] getParcels() {
		return this.packageService.getAll().toArray(new Parcel[0]);
	}
}
