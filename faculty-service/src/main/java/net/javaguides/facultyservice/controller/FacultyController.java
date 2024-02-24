package net.javaguides.facultyservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.facultyservice.dto.FacultyDto;
import net.javaguides.facultyservice.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/faculties")
@AllArgsConstructor
public class FacultyController {

    private FacultyService facultyService;

    // Build save department REST API
    @PostMapping
    public ResponseEntity<FacultyDto> saveFaculty(@RequestBody FacultyDto facultyDto){
        FacultyDto savedFaculty = facultyService.saveFaculty(facultyDto);
        return new ResponseEntity<>(savedFaculty, HttpStatus.CREATED);
    }

    // Build get department rest api
    @GetMapping("{faculty-code}")
    public ResponseEntity<FacultyDto> getFaculty(@PathVariable("faculty-code") String facultycode){
        FacultyDto facultyDto = facultyService.getFacultyByCode(facultycode);
        return new ResponseEntity<>(facultyDto, HttpStatus.OK);
    }
}
