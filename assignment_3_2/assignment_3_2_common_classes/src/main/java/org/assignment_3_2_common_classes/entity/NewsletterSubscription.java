package org.assignment_3_2_common_classes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newsletter_subscription")
public class NewsletterSubscription {

	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String email;

	public NewsletterSubscription() {
		super();
	}

	public NewsletterSubscription(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
