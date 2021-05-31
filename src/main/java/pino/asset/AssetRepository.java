package pino.asset;

import org.springframework.data.repository.CrudRepository;

public interface AssetRepository extends CrudRepository<Asset, Long>{

	Asset findByVin(String vin);
}
