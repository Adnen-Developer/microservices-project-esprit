package microservice.esprit.tn.evenementservice.service;

import microservice.esprit.tn.evenementservice.dto.EvenementDto;

public interface EvenementService {
    EvenementDto saveEvenement(EvenementDto evenementDto);

    EvenementDto getEvenementByCode(String evenementCode);
}
