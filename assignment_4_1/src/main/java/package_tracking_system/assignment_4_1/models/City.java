package package_tracking_system.assignment_4_1.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cities")
@XmlRootElement
public class City implements Serializable {

	private static final long serialVersionUID = 2006560738132088995L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	public City() {
		super();
	}

	public City(String name) {
		super();
		this.name = name;
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
}
