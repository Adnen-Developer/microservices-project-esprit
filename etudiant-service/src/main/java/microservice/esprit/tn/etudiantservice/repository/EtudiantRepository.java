package microservice.esprit.tn.etudiantservice.repository;

import microservice.esprit.tn.etudiantservice.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant , Long> {
}
