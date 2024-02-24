package tn.esprit.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CongeEvaluationResultDto implements Serializable {
    private Boolean canTakeConge;
}
