package microservice.esprit.tn.cabinetservice.repository;

import microservice.esprit.tn.cabinetservice.entity.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinetRepository extends JpaRepository<Cabinet , Long> {
    Cabinet findByCabinetCode(String cabinetCode);
}
