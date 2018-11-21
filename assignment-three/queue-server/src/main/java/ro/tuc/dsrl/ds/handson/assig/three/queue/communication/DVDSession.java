package ro.tuc.dsrl.ds.handson.assig.three.queue.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ro.tuc.dsrl.ds.handson.assig.three.queue.entities.DVD;
import ro.tuc.dsrl.ds.handson.assig.three.queue.queue.DVDQueue;

public class DVDSession extends Thread {

	private DVDQueue queue;
	private Socket clientSocket;
	private ObjectInputStream inFromClient;
	private ObjectOutputStream outToClient;

	public DVDSession(DVDQueue queue, Socket cSocket) {
		this.queue = queue;
		this.clientSocket = cSocket;
		try {
			inFromClient = new ObjectInputStream(clientSocket.getInputStream());
			outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		DVDMessage messageReceived;

		try {
			messageReceived = (DVDMessage) inFromClient.readObject();

			switch (messageReceived.getType()) {
			case "SEND":
				try {
					this.queue.put(messageReceived.getContent());
					sendMessageToClient(new DVDMessage("ACK", null));
				} catch (InterruptedException e) {
					e.printStackTrace();
					sendMessageToClient(new DVDMessage("ERR", null));
				}
				break;
			case "READ":
				try {
					DVD content = this.queue.get();
					sendMessageToClient(new DVDMessage("ACK", content));
				} catch (InterruptedException e) {
					e.printStackTrace();
					sendMessageToClient(new DVDMessage("ERR", null));
				}
				break;
			}

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		closeAll();
	}

	public void sendMessageToClient(DVDMessage messageToSend) {
		try {
			outToClient.writeObject(messageToSend);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void closeAll() {
		try {
			if (inFromClient != null) {
				inFromClient.close();
			}
			if (outToClient != null) {
				outToClient.close();
			}
			if (clientSocket != null) {
				clientSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			inFromClient = null;
			outToClient = null;
			clientSocket = null;
		}
	}
}
