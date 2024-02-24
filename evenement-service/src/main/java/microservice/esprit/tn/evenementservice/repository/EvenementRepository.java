package microservice.esprit.tn.evenementservice.repository;

import microservice.esprit.tn.evenementservice.entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement , Long> {
    Evenement findByEvenementCode(String evenementCode);

}
