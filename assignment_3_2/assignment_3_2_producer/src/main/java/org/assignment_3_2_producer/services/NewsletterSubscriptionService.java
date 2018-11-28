package org.assignment_3_2_producer.services;

import org.assignment_3_2_common_classes.entity.NewsletterSubscription;
import org.assignment_3_2_producer.repository.NewsletterSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsletterSubscriptionService {

	@Autowired
	NewsletterSubscriptionRepository newsletterSubscriptionRepository;

	public void subscribe(String email) {
		NewsletterSubscription subscriptionToAdd = new NewsletterSubscription(email);
		this.newsletterSubscriptionRepository.save(subscriptionToAdd);
	}
}
