package net.javaguides.etudiantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClasseDto {
    private Long id;
    private String classeName;
    private String classeDescription;
    private String classeCode;
}
