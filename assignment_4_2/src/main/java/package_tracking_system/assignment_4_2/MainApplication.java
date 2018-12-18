package package_tracking_system.assignment_4_2;

import javax.xml.ws.Endpoint;

import package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl;

public class MainApplication {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/ws/packages", new ParcelWSImpl());
	}
}
