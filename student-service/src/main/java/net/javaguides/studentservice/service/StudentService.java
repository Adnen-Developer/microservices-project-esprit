package net.javaguides.studentservice.service;

import io.github.resilience4j.retry.annotation.Retry;
import net.javaguides.studentservice.dto.APIResponseDto;
import net.javaguides.studentservice.dto.StudentDto;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);


    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    APIResponseDto getStudentById(Long studentId);
}
