package microservice.esprit.tn.doctorservice.service;

import microservice.esprit.tn.doctorservice.dto.CabinetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CABINET-SERVICE")
public interface APIClient {
    @GetMapping("api/cabinets/{cabinet-code}")
    CabinetDto getCabinet(@PathVariable("cabinet-code") String cabinetCode);
}
