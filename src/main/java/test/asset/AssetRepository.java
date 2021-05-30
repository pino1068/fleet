package test.asset;

import java.util.List;

public interface AssetRepository {

	void removeByVin(String fleet, String vin);
	List<Asset> all(String fleet);
	void add(String fleet, Asset asset);
	void addFleet(String fleet);
}
