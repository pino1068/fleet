package pino.asset;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pino.asset.Asset;
import pino.asset.FleetController;

class FleetApplicationTests {
	
	private static final String DEFAULT_FLEET = "fleet 1";
	private FleetController controller;
	private Map<String, List<Asset>> db;
	
	@BeforeEach
	public void setup() {
		db = new HashMap<>();
		controller = new FleetController(new FleetInMemoryService(db));
	}

	@Test
	public void addFleet(){
		controller.addFleet(DEFAULT_FLEET);
		
		assertEquals(0, db.get(DEFAULT_FLEET).size());
	}
	
	@Test
	public void addVehicleAsAsset() throws Exception {
		db.put(DEFAULT_FLEET, new ArrayList<Asset>());
		controller.addAsset(DEFAULT_FLEET, "VIN_1","vehicle");
		
		assertEquals(1, db.get(DEFAULT_FLEET).size());
		assertEquals("VIN_1", db.get(DEFAULT_FLEET).get(0).getVin());
		assertEquals("vehicle", db.get(DEFAULT_FLEET).get(0).getType());
	}
	
	@Test
	public void removeAssetByVin() throws Exception {
		db.put(DEFAULT_FLEET, new ArrayList<Asset>());
		db.get(DEFAULT_FLEET).add(new Asset("VIN_1","vehicle"));
		
		controller.removeAsset(DEFAULT_FLEET,"VIN_1");
		
		assertEquals(0, db.get(DEFAULT_FLEET).size());
	}
}

