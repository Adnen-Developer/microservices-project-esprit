package net.javaguides.studentservice.service.impl;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.javaguides.studentservice.dto.APIResponseDto;
import net.javaguides.studentservice.dto.ClubDto;
import net.javaguides.studentservice.dto.FacultyDto;
import net.javaguides.studentservice.dto.StudentDto;
import net.javaguides.studentservice.entity.Student;
import net.javaguides.studentservice.mapper.StudentMapper;
import net.javaguides.studentservice.repository.StudentRepository;
import net.javaguides.studentservice.service.APIClient;
import net.javaguides.studentservice.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;

   // private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto);

        Student saveDStudent = studentRepository.save(student);

        StudentDto savedStudentDto = StudentMapper.mapToStudentDto(saveDStudent);

        return savedStudentDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultFaculty")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultFaculty")
    @Override
    public APIResponseDto getStudentById(Long studentId) {

        LOGGER.info("inside getStudentById() method");
        Student student = studentRepository.findById(studentId).get();

//        ResponseEntity<FacultyDto> responseEntity = restTemplate.getForEntity("http://FACULTY-SERVICE/api/faculties/" + student.getFacultyCode(),
//                FacultyDto.class);
//
//        FacultyDto facultyDto = responseEntity.getBody();

        FacultyDto facultyDto = webClient.get()
                .uri("http://localhost:8381/api/faculties/" + student.getFacultyCode())
                .retrieve()
                .bodyToMono(FacultyDto.class)
                .block();

      //  FacultyDto facultyDto = apiClient.getFaculty(student.getFacultyCode());

        ClubDto clubDto = webClient.get()
                .uri("http://localhost:8380/api/clubs/" + student.getClubCode())
                .retrieve()
                .bodyToMono(ClubDto.class)
                .block();

        StudentDto studentDto = StudentMapper.mapToStudentDto(student);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setStudent(studentDto);
        apiResponseDto.setFaculty(facultyDto);
        apiResponseDto.setClub(clubDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultFaculty(Long studentId, Exception exception) {

        LOGGER.info("inside getDefaultFaculty() method");

        Student student = studentRepository.findById(studentId).get();

        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setFacultyName("R&D Faculty");
        facultyDto.setFacultyCode("RD001");
        facultyDto.setFacultyDescription("Research and Development Faculty");

        StudentDto studentDto = StudentMapper.mapToStudentDto(student);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setStudent(studentDto);
        apiResponseDto.setFaculty(facultyDto);
        return apiResponseDto;
    }
}
