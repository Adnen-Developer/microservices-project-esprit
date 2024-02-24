package microservice.esprit.tn.etudiantservice.service;

import microservice.esprit.tn.etudiantservice.dto.APIResponseDto;
import microservice.esprit.tn.etudiantservice.dto.EtudiantDto;

public interface EtudiantService {
    EtudiantDto saveEtudiant(EtudiantDto etudiantDto);

    APIResponseDto getEtudiantById(Long etudiantId);
}
