package package_tracking_system.assignment_4_2.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "parcels")
@XmlRootElement
public class Parcel implements Serializable {

	private static final long serialVersionUID = 4466013202948835457L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private String description;

	@ManyToOne
	private User sender;

	@ManyToOne
	private User receiver;

	@OneToOne
	private Delivery delivery;

	public Parcel() {
		super();
	}

	public Parcel(String name, String description, User sender, User receiver) {
		super();
		this.name = name;
		this.description = description;
		this.sender = sender;
		this.receiver = receiver;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
}
