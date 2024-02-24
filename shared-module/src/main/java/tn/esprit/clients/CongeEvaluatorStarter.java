package tn.esprit.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.dto.CongeEvaluationResultDto;

@FeignClient(name = "CONGE-EVALUATOR-SERVICE")
public interface CongeEvaluatorStarter {

    @GetMapping("conge-evaluator/can-take-conge/{employeId}/{duree}")
    CongeEvaluationResultDto evaluateConge(@PathVariable("employeId") String employeId, @PathVariable("duree") String duree);

}
