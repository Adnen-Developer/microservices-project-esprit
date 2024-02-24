package microservice.esprit.tn.appointmentservice.service.Impl;

import lombok.AllArgsConstructor;
import microservice.esprit.tn.appointmentservice.dto.AppointmentDto;
import microservice.esprit.tn.appointmentservice.entity.Appointment;
import microservice.esprit.tn.appointmentservice.mapper.AppointmentMapper;
import microservice.esprit.tn.appointmentservice.repository.AppointmentRepository;
import microservice.esprit.tn.appointmentservice.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {

        // convert AppointmentDto into Appointment jpa entity
        Appointment appointment = AppointmentMapper.mapToAppointment(appointmentDto);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return AppointmentMapper.mapToAppointmentDto(savedAppointment);
    }

    @Override
    public AppointmentDto getAppointmentByCode(String appointmentCode) {
        Appointment appointment = appointmentRepository.findByAppointmentCode(appointmentCode);
        return AppointmentMapper.mapToAppointmentDto(appointment);
    }
}
