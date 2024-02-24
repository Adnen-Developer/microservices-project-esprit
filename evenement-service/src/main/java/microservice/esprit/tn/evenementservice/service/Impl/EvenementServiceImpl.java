package microservice.esprit.tn.evenementservice.service.Impl;

import lombok.AllArgsConstructor;
import microservice.esprit.tn.evenementservice.dto.EvenementDto;
import microservice.esprit.tn.evenementservice.entity.Evenement;
import microservice.esprit.tn.evenementservice.mapper.EvenementMapper;
import microservice.esprit.tn.evenementservice.repository.EvenementRepository;
import microservice.esprit.tn.evenementservice.service.EvenementService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EvenementServiceImpl implements EvenementService {
    private EvenementRepository evenementRepository;

    @Override
    public EvenementDto saveEvenement(EvenementDto evenementDto) {

        // convert EvenementDto into Evenement jpa entity
        Evenement evenement = EvenementMapper.mapToEvenement(evenementDto);

        Evenement savedEvenement = evenementRepository.save(evenement);

        return EvenementMapper.mapToEvenementDto(savedEvenement);
    }

    @Override
    public EvenementDto getEvenementByCode(String evenementCode) {
        Evenement evenement = evenementRepository.findByEvenementCode(evenementCode);
        return EvenementMapper.mapToEvenementDto(evenement);
    }
}
