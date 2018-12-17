package package_tracking_system.assignment_4_1.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deliveries")
public class Delivery implements Serializable {

	private static final long serialVersionUID = 5650244159165925359L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "origin_city_id")
	private City originCity;

	@ManyToOne
	@JoinColumn(name = "destination_city_id")
	private City destinationCity;
	
	@Column
	private String route;

	@Column
	private Boolean tracked;

	public Delivery() {
		super();
	}

	public Delivery(City originCity, City destinationCity, Boolean tracked) {
		super();
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.tracked = tracked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public City getOriginCity() {
		return originCity;
	}

	public void setOriginCity(City originCity) {
		this.originCity = originCity;
	}

	public City getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(City destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Boolean getTracked() {
		return tracked;
	}

	public void setTracked(Boolean tracked) {
		this.tracked = tracked;
	}
}
