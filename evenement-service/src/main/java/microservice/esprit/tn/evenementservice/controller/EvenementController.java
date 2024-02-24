package microservice.esprit.tn.etudiantservice.controller;

import lombok.AllArgsConstructor;
import microservice.esprit.tn.evenementservice.dto.EvenementDto;
import microservice.esprit.tn.evenementservice.service.EvenementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/evenements")
@AllArgsConstructor
public class EvenementController {
    private EvenementService evenementService;

    // Build Save Organization REST API
    @PostMapping
    public ResponseEntity<EvenementDto> saveEvenement(@RequestBody EvenementDto evenementDto){
        EvenementDto saveEvenement = evenementService.saveEvenement(evenementDto);
        return new ResponseEntity<>(saveEvenement, HttpStatus.CREATED);
    }

    // Build Get Organization by Code REST API
    @GetMapping("{code}")
    public ResponseEntity<EvenementDto> getEvenement(@PathVariable("code") String evenementCode){
        EvenementDto evenementDto = evenementService.getEvenementByCode(evenementCode);
        return ResponseEntity.ok(evenementDto);
    }

}
