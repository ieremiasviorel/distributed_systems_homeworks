package ro.tuc.dsrl.ds.handson.assig.three.queue.start;

import java.io.IOException;

import ro.tuc.dsrl.ds.handson.assig.three.queue.communication.DVDServer;
import ro.tuc.dsrl.ds.handson.assig.three.queue.communication.Server;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-server
 * @Since: Sep 1, 2015
 * @Description: Serves for starting the server on the specified port.
 */
public class ServerStart {

	private static final int PORT = 8888;
	private static final int DVD_SERVICE_1_PORT = 8890;
	private static final int DVD_SERVICE_2_PORT = 8892;

	private ServerStart() {
	}

	public static void main(String[] args) {
		try {
			new Server(PORT);
			System.out.println("Queue server started.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			new DVDServer(DVD_SERVICE_1_PORT);
			System.out.println("DVD Queue server 1 started.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			new DVDServer(DVD_SERVICE_2_PORT);
			System.out.println("DVD Queue server 2 started.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
