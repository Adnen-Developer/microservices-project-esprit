package microservice.esprit.tn.doctorservice.mapper;

import microservice.esprit.tn.doctorservice.dto.DoctorDto;
import microservice.esprit.tn.doctorservice.entity.Doctor;

public class DoctorMapper {
    public static DoctorDto mapToDoctorDto(Doctor doctor){
        DoctorDto doctorDto = new DoctorDto(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getCabinetCode(),
                doctor.getAppointmentCode()
        );
        return doctorDto;
    }

    public static Doctor mapToDoctor(DoctorDto doctorDto){
        Doctor doctor = new Doctor(
                doctorDto.getId(),
                doctorDto.getFirstName(),
                doctorDto.getLastName(),
                doctorDto.getEmail(),
                doctorDto.getCabinetCode(),
                doctorDto.getAppointmentCode()
        );
        return doctor;
    }
}
