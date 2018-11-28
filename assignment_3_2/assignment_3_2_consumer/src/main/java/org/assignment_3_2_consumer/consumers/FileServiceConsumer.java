package org.assignment_3_2_consumer.consumers;

import java.io.IOException;

import org.assignment_3_2_common_classes.entity.DVD;
import org.assignment_3_2_consumer.service.FileService;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class FileServiceConsumer extends DefaultConsumer {

	FileService fileService;
	
	public FileServiceConsumer(Channel channel) {
		super(channel);
		fileService = new FileService();
	}
	
	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
			throws IOException {
		DVD dvd = DVD.fromBytes(body);
		fileService.generateFile(dvd.getTitle(), dvd.toString());
	}
}
