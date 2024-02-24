package microservice.esprit.tn.cabinetservice.controller;

import lombok.AllArgsConstructor;
import microservice.esprit.tn.cabinetservice.dto.CabinetDto;
import microservice.esprit.tn.cabinetservice.service.CabinetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cabinets")
@AllArgsConstructor
public class CabinetController {
    private CabinetService cabinetService ;

    // Build save Cabinet REST API
    @PostMapping
    public ResponseEntity<CabinetDto> saveCabinet(@RequestBody CabinetDto cabinetDto){
        CabinetDto savedCabinet = cabinetService.saveCabinet(cabinetDto);
        return new ResponseEntity<>(savedCabinet, HttpStatus.CREATED);
    }

    // Build get cabinet rest api
    @GetMapping("{cabinet-code}")
    public ResponseEntity<CabinetDto> getCabinet(@PathVariable("cabinet-code") String cabinetCode){
        CabinetDto cabinetDto = cabinetService.getCabinetByCode(cabinetCode);
        return new ResponseEntity<>(cabinetDto, HttpStatus.OK);
    }
}
