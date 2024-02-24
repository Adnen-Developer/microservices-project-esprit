package net.javaguides.doctorservice.service.impl;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.javaguides.doctorservice.dto.APIResponseDto;
import net.javaguides.doctorservice.dto.CabinetDto;
import net.javaguides.doctorservice.dto.DoctorDto;
import net.javaguides.doctorservice.dto.AppointmentDto;
import net.javaguides.doctorservice.entity.Doctor;
import net.javaguides.doctorservice.mapper.DoctorMapper;
import net.javaguides.doctorservice.repository.DoctorRepository;
import net.javaguides.doctorservice.service.APIClient;
import net.javaguides.doctorservice.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {


        private static final Logger LOGGER = LoggerFactory.getLogger(DoctorServiceImpl.class);

        private DoctorRepository doctorRepository;

        // private RestTemplate restTemplate;
        private WebClient webClient;
        private APIClient apiClient;

        @Override
        public DoctorDto saveDoctor(DoctorDto doctorDto) {

            Doctor doctor = DoctorMapper.mapToDoctor(doctorDto);

            Doctor saveDDoctor = doctorRepository.save(doctor);

            DoctorDto savedDoctorDto = DoctorMapper.mapToDoctorDto(saveDDoctor);

            return savedDoctorDto;
        }

        //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
        @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultCabinet")
        @Override
        public APIResponseDto getDoctorById(Long doctorId) {

            LOGGER.info("inside getEmployeeById() method");
            Doctor doctor = doctorRepository.findById(doctorId).get();

//        ResponseEntity<CabinetDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + doctor.getDepartmentCode(),
//                CabinetDto.class);
//
//        CabinetDto cabinetDto = responseEntity.getBody();

            CabinetDto cabinetDto = webClient.get()
                    .uri("http://localhost:8480/api/cabinets/" + doctor.getCabinetCode())
                    .retrieve()
                    .bodyToMono(CabinetDto.class)
                    .block();

            //  CabinetDto cabinetDto = apiClient.getCabinet(doctor.getCabinetCode());

            AppointmentDto appointmentDto = webClient.get()
                    .uri("http://localhost:8481/api/appointments/" + doctor.getAppointmentCode())
                    .retrieve()
                    .bodyToMono(AppointmentDto.class)
                    .block();

            DoctorDto doctorDto = DoctorMapper.mapToDoctorDto(doctor);

            APIResponseDto apiResponseDto = new APIResponseDto();
            apiResponseDto.setDoctor(doctorDto);
            apiResponseDto.setCabinet(cabinetDto);
            apiResponseDto.setAppointment(appointmentDto);
            return apiResponseDto;
        }

        public APIResponseDto getDefaultCabient(Long doctorId, Exception exception) {

            LOGGER.info("inside getDefaultCabient() method");

            Doctor doctor = doctorRepository.findById(doctorId).get();

            CabinetDto cabinetDto = new CabinetDto();
            cabinetDto.setCabinetName("R&D Cabinet");
            cabinetDto.setCabinetCode("RD001");
            cabinetDto.setCabinetDescription("Research and Development Cabinet");

            DoctorDto doctorDto = DoctorMapper.mapToDoctorDto(doctor);

            APIResponseDto apiResponseDto = new APIResponseDto();
            apiResponseDto.setDoctor(doctorDto);
            apiResponseDto.setCabinet(cabinetDto);
            return apiResponseDto;
        }
}
