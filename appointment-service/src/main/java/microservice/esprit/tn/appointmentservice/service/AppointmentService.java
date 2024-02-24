package microservice.esprit.tn.appointmentservice.service;

import microservice.esprit.tn.appointmentservice.dto.AppointmentDto;

public interface AppointmentService {
    AppointmentDto saveAppointment(AppointmentDto appointmentDto);

    AppointmentDto getAppointmentByCode(String appointmentCode);
}
