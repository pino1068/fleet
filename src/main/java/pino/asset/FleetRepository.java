package pino.asset;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FleetRepository extends JpaRepository<Fleet, Long>{

	Fleet findByName(String fleet);
}
