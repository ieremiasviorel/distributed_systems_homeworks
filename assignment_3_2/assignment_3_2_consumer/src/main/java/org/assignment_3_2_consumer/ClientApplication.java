package org.assignment_3_2_consumer;

import org.assignment_3_2_consumer.communication.QueueCommunication;

public class ClientApplication {
	
	private static final String HOST = "localhost";
	private static final String EXCHANGE = "dvd_exchange";
	
	public static void main(String[] args) throws Exception {

		QueueCommunication queueCommunication = new QueueCommunication();
		queueCommunication.init(HOST);
		
		queueCommunication.consumeEmailServiceQueue(EXCHANGE);
		queueCommunication.consumeFileServiceQueue(EXCHANGE);
	}
}