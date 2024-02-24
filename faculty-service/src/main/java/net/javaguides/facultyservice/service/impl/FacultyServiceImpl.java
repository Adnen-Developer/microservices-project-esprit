package net.javaguides.facultyservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.facultyservice.dto.FacultyDto;
import net.javaguides.facultyservice.entity.Faculty;
import net.javaguides.facultyservice.mapper.FacultyMapper;
import net.javaguides.facultyservice.repository.FacultyRepository;
import net.javaguides.facultyservice.service.FacultyService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository facultyRepository;

    @Override
    public FacultyDto saveFaculty(FacultyDto facultyDto) {

        // convert department dto to department jpa entity
        Faculty faculty = FacultyMapper.mapToFaculty(facultyDto);

        Faculty savedFaculty = facultyRepository.save(faculty);

        FacultyDto savedFacultyDto = FacultyMapper.mapToFacultyDto(savedFaculty);

        return savedFacultyDto;
    }

    @Override
    public FacultyDto getFacultyByCode(String facultyCode) {

        Faculty faculty = facultyRepository.findByFacultyCode(facultyCode);

        FacultyDto facultyDto = FacultyMapper.mapToFacultyDto(faculty);

        return facultyDto;
    }
}
