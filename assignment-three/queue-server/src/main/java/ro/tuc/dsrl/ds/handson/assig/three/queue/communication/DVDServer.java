package ro.tuc.dsrl.ds.handson.assig.three.queue.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ro.tuc.dsrl.ds.handson.assig.three.queue.queue.DVDQueue;

public class DVDServer implements Runnable {

	private ServerSocket serverSocket;
	private DVDQueue queue;

	/**
	 * Create a socket object from the ServerSocket to listen to and accept
	 * connections
	 * 
	 * @param port the port on which the ServerSocket will be bound to
	 * @throws IOException
	 */
	public DVDServer(int port) throws IOException {
		queue = new DVDQueue();
		serverSocket = new ServerSocket(port);
		new Thread(this).start();
	}

	/**
	 * Accepts connections from clients and assigns a thread to deal with the
	 * messages from and to the respective client.
	 */
	public void run() {
		while (true) {
			try {
				synchronized (this) {
					Socket clientSocket;
					clientSocket = serverSocket.accept();
					DVDSession cThread = new DVDSession(queue, clientSocket);
					cThread.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
