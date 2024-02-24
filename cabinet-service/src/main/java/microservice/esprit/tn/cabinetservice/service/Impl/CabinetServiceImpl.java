package microservice.esprit.tn.cabinetservice.service.Impl;

import lombok.AllArgsConstructor;
import microservice.esprit.tn.cabinetservice.dto.CabinetDto;
import microservice.esprit.tn.cabinetservice.entity.Cabinet;
import microservice.esprit.tn.cabinetservice.mapper.CabinetMapper;
import microservice.esprit.tn.cabinetservice.repository.CabinetRepository;
import microservice.esprit.tn.cabinetservice.service.CabinetService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CabinetServiceImpl implements CabinetService {
    private CabinetRepository cabinetRepository ;

    @Override
    public CabinetDto saveCabinet(CabinetDto cabinetDto) {

        // convert cabinet dto to cabinet jpa entity
        Cabinet cabinet = CabinetMapper.mapToCabinet(cabinetDto);

        Cabinet savedCabinet = cabinetRepository.save(cabinet);

        CabinetDto savedCabinetDto = CabinetMapper.mapToCabinetDto(savedCabinet);

        return savedCabinetDto;
    }

    @Override
    public CabinetDto getCabinetByCode(String cabinetCode) {

        Cabinet cabinet = cabinetRepository.findByCabinetCode(cabinetCode);

        CabinetDto cabinetDto = CabinetMapper.mapToCabinetDto(cabinet);

        return cabinetDto;
    }
}
