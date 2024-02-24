package microservice.esprit.tn.doctorservice.service;

import microservice.esprit.tn.doctorservice.dto.APIResponseDto;
import microservice.esprit.tn.doctorservice.dto.DoctorDto;
import microservice.esprit.tn.doctorservice.entity.Doctor;

import java.util.List;
import java.util.Map;

public interface DoctorService {
    DoctorDto saveDoctor(DoctorDto doctorDto);

    APIResponseDto getDoctorById(Long doctorId);
}
