package net.javaguides.studentservice.service;

import net.javaguides.studentservice.dto.FacultyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FACULTY-SERVICE")
public interface APIClient {
    // Build get department rest api
    @GetMapping("api/faculties/{faculty-code}")
    FacultyDto getFaculty(@PathVariable("faculty-code") String facultyCode);
}
