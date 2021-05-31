package pino.asset;

import java.util.List;

import org.springframework.stereotype.Service;

public interface FleetService {
	void removeByVin(String fleet, String vin);
	List<Asset> all(String fleet);
	void add(String fleet, Asset asset);
	void addFleet(String fleet);
}
