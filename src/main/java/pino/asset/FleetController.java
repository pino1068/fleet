package pino.asset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FleetController {
	
	FleetService service;

	@Autowired
	public FleetController(FleetService db) {
		this.service = db;
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello "+name;
	}

	@GetMapping("/addAsset")
	public void addAsset(
			@RequestParam(value = "fleet", defaultValue = "1") String fleet, 
			@RequestParam(value = "vin", defaultValue = "11") String vin, 
			@RequestParam(value = "type", defaultValue = "vehicle") String type) {
		this.service.add(fleet, new Asset(vin, type));
	}

	@GetMapping("/getAssets")
	public List<Asset> getAssets(
			@RequestParam(value = "fleet", defaultValue = "1") String fleet) {
		return service.all(fleet);
	}

	public void removeAsset(String fleet, String vin) {
		service.removeByVin(fleet, vin);
	}

	@GetMapping("/addFleet")
	public void addFleet(@RequestParam(value = "fleet", defaultValue = "1") String fleet) {
		service.addFleet(fleet);
	}
}
