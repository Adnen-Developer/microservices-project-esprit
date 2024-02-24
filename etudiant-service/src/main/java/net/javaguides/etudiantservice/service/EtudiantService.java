package net.javaguides.etudiantservice.service;


import net.javaguides.etudiantservice.dto.APIResponseDto;
import net.javaguides.etudiantservice.dto.EtudiantDto;

public interface EtudiantService {
    EtudiantDto saveEtudiant(EtudiantDto etudiantDto);

    APIResponseDto getEtudiantById(Long etudiantId);
}
