package microservice.esprit.tn.doctorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    private String appointmentName;
    private String appointmentDescription;
    private String appointmentCode;
    private LocalDateTime createdDate;
}
