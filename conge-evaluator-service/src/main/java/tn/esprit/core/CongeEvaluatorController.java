package tn.esprit.core;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.dto.CongeEvaluationResultDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("conge-evaluator")
public class CongeEvaluatorController {

    @GetMapping("can-take-conge/{employeId}/{duree}")
    public ResponseEntity<CongeEvaluationResultDto> addConge(@PathVariable Long employeId, @PathVariable Integer duree) {
        return ResponseEntity.ok(new CongeEvaluationResultDto(true));
    }

}
