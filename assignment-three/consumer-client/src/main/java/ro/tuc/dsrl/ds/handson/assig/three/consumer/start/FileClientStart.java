package ro.tuc.dsrl.ds.handson.assig.three.consumer.start;

import java.io.IOException;

import ro.tuc.dsrl.ds.handson.assig.three.consumer.connection.DVDQueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.consumer.service.FileService;
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
public class FileClientStart {

	private static final String HOST = "localhost";
	private static final int PORT = 8892;

	private static int fileCount = 0;

	private FileClientStart() {
	}

	public static void main(String[] args) {
		DVDQueueServerConnection fileQueue = new DVDQueueServerConnection(HOST, PORT);

		FileService fileService = new FileService();

		DVD dvdMessage = null;

		while (true) {
			try {
				dvdMessage = fileQueue.readDVDMessage();
				System.out.println("Writing file #" + fileCount);
				fileService.generateFile("DVD_" + fileCount++, dvdMessage.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
