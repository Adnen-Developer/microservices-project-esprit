package net.javaguides.etudiantservice.mapper;


import net.javaguides.etudiantservice.dto.EtudiantDto;
import net.javaguides.etudiantservice.entity.Etudiant;

public class EtudiantMapper {
    public static EtudiantDto mapToEtudiantDto(Etudiant etudiant){
        EtudiantDto etudiantDto = new EtudiantDto(
                etudiant.getId(),
                etudiant.getFirstName(),
                etudiant.getLastName(),
                etudiant.getEmail(),
                etudiant.getClasseCode(),
                etudiant.getEvenementCode()
        );
        return etudiantDto;
    }

    public static Etudiant mapToEtudiant(EtudiantDto etudiantDto){
        Etudiant etudiant = new Etudiant(
                etudiantDto.getId(),
                etudiantDto.getFirstName(),
                etudiantDto.getLastName(),
                etudiantDto.getEmail(),
                etudiantDto.getClasseCode(),
                etudiantDto.getEvenementCode()
        );
        return etudiant;
    }
}
