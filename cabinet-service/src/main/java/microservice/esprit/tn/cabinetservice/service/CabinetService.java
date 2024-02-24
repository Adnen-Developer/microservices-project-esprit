package microservice.esprit.tn.cabinetservice.service;

import microservice.esprit.tn.cabinetservice.dto.CabinetDto;

public interface CabinetService {
    CabinetDto saveCabinet(CabinetDto cabinetDto);

    CabinetDto getCabinetByCode(String code);
}
