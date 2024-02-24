package net.javaguides.doctorservice.service;

import net.javaguides.doctorservice.dto.APIResponseDto;
import net.javaguides.doctorservice.dto.DoctorDto;

public interface DoctorService {
    DoctorDto saveDoctor(DoctorDto doctorDto);

    APIResponseDto getDoctorById(Long doctorId);
}
