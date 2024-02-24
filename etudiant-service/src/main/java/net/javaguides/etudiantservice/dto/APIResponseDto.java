package net.javaguides.etudiantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EtudiantDto etudiant;
    private ClasseDto classe;
    private EvenementDto evenement;
}
