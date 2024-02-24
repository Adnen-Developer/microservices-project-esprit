package microservice.esprit.tn.etudiantservice.service;

import microservice.esprit.tn.etudiantservice.dto.ClasseDto;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLASSE-SERVICE")
public interface APIClient {
    // Build get classe rest api
    @GetMapping("api/classes/{classe-code}")
    ClasseDto getClasse(@PathVariable("classe-code") String classeCode);
}
