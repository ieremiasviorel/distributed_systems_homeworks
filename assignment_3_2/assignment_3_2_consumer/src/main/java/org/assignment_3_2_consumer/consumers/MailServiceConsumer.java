package org.assignment_3_2_consumer.consumers;

import java.io.IOException;
import java.util.List;

import org.assignment_3_2_common_classes.entity.DVD;
import org.assignment_3_2_common_classes.entity.NewsletterSubscription;
import org.assignment_3_2_consumer.repository.NewsletterDAO;
import org.assignment_3_2_consumer.service.MailService;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MailServiceConsumer extends DefaultConsumer {

	NewsletterDAO newsletterDAO;
	MailService mailService;

	public MailServiceConsumer(Channel channel) {
		super(channel);
		newsletterDAO = new NewsletterDAO();
		mailService = new MailService();
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
			throws IOException {
		DVD dvd = DVD.fromBytes(body);
		List<NewsletterSubscription> mailingList = newsletterDAO.getAll();
		for (NewsletterSubscription n : mailingList) {
			mailService.sendMail(n.getEmail(), "[NEW MOVIE]", dvd.toString());
		}
	}
}
