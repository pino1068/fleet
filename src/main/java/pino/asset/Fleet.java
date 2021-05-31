package pino.asset;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fleet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(
			mappedBy = "fleet", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true) 
	List<Asset> assets = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(Asset asset) {
		this.assets.add(asset);
	}

}
