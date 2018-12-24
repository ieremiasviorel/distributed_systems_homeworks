package org.assignment_3_2_consumer.communication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.assignment_3_2_consumer.consumers.FileServiceConsumer;
import org.assignment_3_2_consumer.consumers.MailServiceConsumer;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Service
public class QueueCommunication {

	private Connection connection;
	private Channel channel;

	public void init(String hostName) throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(hostName);
		connection = factory.newConnection();
		channel = connection.createChannel();
	}

	public void consumeEmailServiceQueue(String exchangeName) throws IOException {
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, exchangeName, "");
		channel.basicConsume(queueName, true, new MailServiceConsumer(channel));
	}

	public void consumeFileServiceQueue(String exchangeName) throws IOException {
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, exchangeName, "");
		channel.basicConsume(queueName, true, new FileServiceConsumer(channel));
	}

	public void destroy() throws IOException, TimeoutException {
		channel.close();
		connection.close();
	}
}
