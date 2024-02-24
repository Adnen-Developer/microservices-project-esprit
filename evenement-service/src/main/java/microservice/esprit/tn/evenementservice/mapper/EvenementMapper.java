package microservice.esprit.tn.evenementservice.mapper;

import microservice.esprit.tn.evenementservice.dto.EvenementDto;
import microservice.esprit.tn.evenementservice.entity.Evenement;

public class EvenementMapper {
    public static EvenementDto mapToEvenementDto(Evenement evenement){
        EvenementDto evenementDto = new EvenementDto(
                evenement.getId(),
                evenement.getEvenementName(),
                evenement.getEvenementDescription(),
                evenement.getEvenementCode(),
                evenement.getCreatedDate()
        );
        return evenementDto;
    }

    public static Evenement mapToEvenement(EvenementDto evenementDto){
        Evenement evenement = new Evenement(
                evenementDto.getId(),
                evenementDto.getEvenementName(),
                evenementDto.getEvenementDescription(),
                evenementDto.getEvenementCode(),
                evenementDto.getCreatedDate()
        );
        return evenement;
    }
}
