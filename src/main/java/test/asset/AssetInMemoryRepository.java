package test.asset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AssetInMemoryRepository implements AssetRepository {

	private Map<String, List<Asset>> db = new HashMap<>();

	public AssetInMemoryRepository(Map<String, List<Asset>> db) {
		this.db = db;
	}

	@Override
	public void removeByVin(String fleet, String vin) {
		db.get(fleet).removeIf(a -> a.getVin().equals(vin));
	}

	@Override
	public List<Asset> all(String fleet) {
		return db.get(fleet);
	}

	@Override
	public void add(String fleet, Asset asset) {
		db.get(fleet).add(asset);
	}

	@Override
	public void addFleet(String fleet) {
		db.put(fleet, new ArrayList<>());
	} 
}
