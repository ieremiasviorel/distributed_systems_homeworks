package package_tracking_system.assignment_4_1;

import javax.xml.ws.Endpoint;

import package_tracking_system.assignment_4_1.web_services.CityWSImpl;

public class MainApplication {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/ws/city", new CityWSImpl());
	}
}