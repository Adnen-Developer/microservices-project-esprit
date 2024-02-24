package microservice.esprit.tn.evenementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EvenementDto {
    private Long id;
    private String evenementName;
    private String evenementDescription;
    private String evenementCode;
    private LocalDateTime createdDate;
}
