package microservice.esprit.tn.appointmentservice.repository;

import microservice.esprit.tn.appointmentservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
    Appointment findByAppointmentCode(String appointmentCode);
}
