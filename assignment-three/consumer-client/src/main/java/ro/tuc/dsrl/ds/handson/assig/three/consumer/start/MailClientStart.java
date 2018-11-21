package ro.tuc.dsrl.ds.handson.assig.three.consumer.start;

import java.io.IOException;

import ro.tuc.dsrl.ds.handson.assig.three.consumer.connection.DVDQueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.consumer.service.MailService;
import ro.tuc.dsrl.ds.handson.assig.three.queue.entities.DVD;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description: Starting point for the Consumer Client application. This
 *               application will run in an infinite loop and retrieve messages
 *               from the queue server and send e-mails with them as they come.
 */
public class MailClientStart {

	private static final String HOST = "localhost";
	private static final int PORT = 8890;

	private MailClientStart() {
	}

	public static void main(String[] args) {
		DVDQueueServerConnection dvdQueue = new DVDQueueServerConnection(HOST, PORT);

		MailService mailService = new MailService("sender email address", "sender email password");
		
		DVD dvdMessage;

		while (true) {
			try {
				dvdMessage = dvdQueue.readDVDMessage();
				System.out.println("Sending mail " + dvdMessage.toString());
				mailService.sendMail("receiver email address", "Default Mail Title", dvdMessage.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
