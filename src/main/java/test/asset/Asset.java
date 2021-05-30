package test.asset;

public class Asset {

	private String vin;
	private String type;

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
