package microservice.esprit.tn.classeservice.repository;

import microservice.esprit.tn.classeservice.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe , Long> {
    Classe findByClasseCode(String classeCode);
}
