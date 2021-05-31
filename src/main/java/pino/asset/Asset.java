package pino.asset;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String vin;
	private String type;
	
	@ManyToOne Fleet fleet;
	
	public Asset() {
	}
	
	public Long getId() {
		return id;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Asset(String vin, String type) {
		this.vin = vin;
		this.type = type;
	}

	public String getVin() {
		return vin;
	}

	public String getType() {
		return type;
	}
}
