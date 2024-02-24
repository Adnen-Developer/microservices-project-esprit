package microservice.esprit.tn.cabinetservice.mapper;

import microservice.esprit.tn.cabinetservice.dto.CabinetDto;
import microservice.esprit.tn.cabinetservice.entity.Cabinet;

public class CabinetMapper {
    public static CabinetDto mapToCabinetDto(Cabinet cabinet){
        CabinetDto cabinetDto = new CabinetDto(
                cabinet.getId(),
                cabinet.getCabinetName(),
                cabinet.getCabinetDescription(),
                cabinet.getCabinetCode()
        );
        return cabinetDto;
    }

    public static Cabinet mapToCabinet(CabinetDto cabinetDto){
        Cabinet cabinet = new Cabinet(
                cabinetDto.getId(),
                cabinetDto.getCabinetName(),
                cabinetDto.getCabinetDescription(),
                cabinetDto.getCabinetCode()
        );
        return cabinet;
    }
}
