package net.javaguides.doctorservice.service;

import net.javaguides.doctorservice.dto.CabinetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CABINET-SERVICE")
public interface APIClient {
    // Build get department rest api
    @GetMapping("api/cabinets/{department-code}")
    CabinetDto getCabinet(@PathVariable("cabinet-code") String cabinetCode);
}
