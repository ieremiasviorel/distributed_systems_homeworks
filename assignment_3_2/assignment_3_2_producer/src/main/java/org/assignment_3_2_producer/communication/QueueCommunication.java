package org.assignment_3_2_producer.communication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.assignment_3_2_common_classes.entity.DVD;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Service
public class QueueCommunication {

	private static final String HOST = "localhost";
	private static final String EXCHANGE_NAME = "dvd_exchange";
	
	private Channel channel;

	public QueueCommunication() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		Connection connection = factory.newConnection();
		channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
	}

	public void publishMessage(DVD dvd) throws IOException {
		channel.basicPublish(EXCHANGE_NAME, "", null, dvd.getBytes());
	}
}
