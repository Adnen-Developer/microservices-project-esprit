package microservice.esprit.tn.etudiantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String classeCode;
    private String evenementCode;
}
