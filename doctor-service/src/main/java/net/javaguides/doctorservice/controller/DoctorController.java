package net.javaguides.doctorservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.doctorservice.dto.APIResponseDto;
import net.javaguides.doctorservice.dto.DoctorDto;
import net.javaguides.doctorservice.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/doctors")
@AllArgsConstructor
public class DoctorController {

    private DoctorService doctorService;

    // Build Save Doctor REST API
    @PostMapping
    public ResponseEntity<DoctorDto> saveDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto savedDoctor = doctorService.saveDoctor(doctorDto);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    // Build Get Doctor REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getDoctor(@PathVariable("id") Long doctorId){
        APIResponseDto apiResponseDto = doctorService.getDoctorById(doctorId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
