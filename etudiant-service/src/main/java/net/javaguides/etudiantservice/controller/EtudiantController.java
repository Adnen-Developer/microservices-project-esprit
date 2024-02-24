package net.javaguides.etudiantservice.controller;

import lombok.AllArgsConstructor;

import net.javaguides.etudiantservice.dto.APIResponseDto;
import net.javaguides.etudiantservice.dto.EtudiantDto;
import net.javaguides.etudiantservice.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/etudiants")
@AllArgsConstructor
public class EtudiantController {
    private EtudiantService etudiantService;

    // Build Save Employee REST API
    @PostMapping
    public ResponseEntity<EtudiantDto> saveEtudiant(@RequestBody EtudiantDto etudiantDto){
        EtudiantDto savedEtudiant = etudiantService.saveEtudiant(etudiantDto);
        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
    }

    // Build Get Etudiant REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long etudiantId){
        APIResponseDto apiResponseDto = etudiantService.getEtudiantById(etudiantId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

}
