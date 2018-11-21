package ro.tuc.dsrl.ds.handson.assig.three.producer.start;

import java.io.IOException;

import ro.tuc.dsrl.ds.handson.assig.three.producer.connection.DVDQueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.producer.connection.QueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.queue.entities.DVD;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description: Starting point for the Producer Client application. This
 *               application will send several messages to be inserted in the
 *               queue server (i.e. to be sent via email by a consumer).
 */
public class ClientStart {
	private static final String HOST = "localhost";
	private static final int PORT = 8888;
	private static final int DVD_SERVICE_1_PORT = 8890;
	private static final int DVD_SERVICE_2_PORT = 8892;

	private ClientStart() {
	}

	public static void main(String[] args) {
		QueueServerConnection queue = new QueueServerConnection(HOST, PORT);
		DVDQueueServerConnection dvdService1Queue = new DVDQueueServerConnection(HOST, DVD_SERVICE_1_PORT);
		DVDQueueServerConnection dvdService2Queue = new DVDQueueServerConnection(HOST, DVD_SERVICE_2_PORT);

		try {
			for (int i = 0; i < 5; i++) {
				DVD dvd = new DVD("DVD #" + i, 2000, 100);
				queue.writeMessage(dvd.toString());
				dvdService1Queue.writeDVDMessage(dvd);
				dvdService2Queue.writeDVDMessage(dvd);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
