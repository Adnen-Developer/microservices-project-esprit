package microservice.esprit.tn.appointmentservice.mapper;

import microservice.esprit.tn.appointmentservice.dto.AppointmentDto;
import microservice.esprit.tn.appointmentservice.entity.Appointment;

public class AppointmentMapper {
    public static AppointmentDto mapToAppointmentDto(Appointment appointment){
        AppointmentDto appointmentDto = new AppointmentDto(
                appointment.getId(),
                appointment.getAppointmentName(),
                appointment.getAppointmentDescription(),
                appointment.getAppointmentCode(),
                appointment.getCreatedDate()
        );
        return appointmentDto;
    }

    public static Appointment mapToAppointment(AppointmentDto appointmentDto){
        Appointment appointment = new Appointment(
                appointmentDto.getId(),
                appointmentDto.getAppointmentName(),
                appointmentDto.getAppointmentDescription(),
                appointmentDto.getAppointmentCode(),
                appointmentDto.getCreatedDate()
        );
        return appointment;
    }
}
