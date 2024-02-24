package net.javaguides.doctorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private DoctorDto doctor;
    private CabinetDto cabinet;
    private AppointmentDto appointment;
}
