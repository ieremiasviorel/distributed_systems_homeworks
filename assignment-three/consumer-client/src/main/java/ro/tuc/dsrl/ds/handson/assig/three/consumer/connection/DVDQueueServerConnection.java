package ro.tuc.dsrl.ds.handson.assig.three.consumer.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ro.tuc.dsrl.ds.handson.assig.three.queue.communication.DVDMessage;
import ro.tuc.dsrl.ds.handson.assig.three.queue.entities.DVD;

public class DVDQueueServerConnection {

	private String host;
	private int port;

	public DVDQueueServerConnection(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public boolean writeDVDMessage(DVD messageToSend) throws IOException {
		Socket clientSocket = new Socket(host, port);
		ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		outToServer.writeObject(new DVDMessage("SEND", messageToSend));

		DVDMessage response;
		try {
			response = (DVDMessage) inFromServer.readObject();
		} catch (ClassNotFoundException e) {
			response = null;
			e.printStackTrace();
		}

		outToServer.close();
		inFromServer.close();
		clientSocket.close();

		return (response != null && response.getType().equals("ACK"));
	}

	public DVD readDVDMessage() throws IOException {
		Socket clientSocket = new Socket(host, port);
		ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		outToServer.writeObject(new DVDMessage("READ", null));

		DVDMessage response;
		try {
			response = (DVDMessage) inFromServer.readObject();
		} catch (ClassNotFoundException e) {
			response = null;
			e.printStackTrace();
		}

		outToServer.close();
		inFromServer.close();
		clientSocket.close();

		if (response == null || !response.getType().equals("ACK"))
			return null;

		return response.getContent();
	}
}
