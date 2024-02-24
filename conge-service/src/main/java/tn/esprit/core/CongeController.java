package tn.esprit.core;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.clients.CongeEvaluatorStarter;
import tn.esprit.logger.SharedLogger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping("conge")
public class CongeController {

    private final SharedLogger logger;

    private final CongeRepository congeRepository;

    private final CongeEvaluatorStarter evaluatorStarter;

    public static long daysBetween(Date date1, Date date2) {
        long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    @PostMapping("")
    public ResponseEntity<Conge> addConge(@RequestBody Conge conge) {
        Boolean isValidated = this.evaluatorStarter.evaluateConge(conge.getEmployeeId(), daysBetween(conge.getStartDate(), conge.getEndDate()) + "").getCanTakeConge();
        if (isValidated) {
            logger.info("Conge for employee"+ conge.getEmployeeId() +" validated");
            return ResponseEntity.ok(congeRepository.save(conge));
        } else {
            throw new RuntimeException("Conge not validated");
        }
    }

    @GetMapping("/{id}")
    public Conge getConge(@PathVariable Long id) {
        return congeRepository.findById(id).orElse(null);
    }
}
