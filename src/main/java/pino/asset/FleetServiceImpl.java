package pino.asset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FleetServiceImpl implements FleetService {
	@Autowired
	FleetRepository repo;
	@Autowired
	AssetRepository assets;

	@Override
	public void removeByVin(String fleet, String vin) {
		Asset asset = assets.findByVin(vin);
		repo.findByName(fleet).assets.remove(asset);
	}

	@Override
	public List<Asset> all(String fleet) {
		return repo.findByName(fleet).assets;
	}

	@Override
	public void add(String fleet, Asset asset) {
		Fleet it = repo.findByName(fleet);
		it.add(asset);
		asset.fleet = it;
		repo.save(it);
	}

	@Override
	public void addFleet(String fleet) {
		Fleet it = new Fleet();
		it.setName(fleet);
		repo.save(it);
	}
}
