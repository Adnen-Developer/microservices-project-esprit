package net.javaguides.studentservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.studentservice.dto.APIResponseDto;
import net.javaguides.studentservice.dto.StudentDto;
import net.javaguides.studentservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    // Build Save Student REST API
    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto savedEmployee = studentService.saveStudent(studentDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Student REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getStudent(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = studentService.getStudentById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
