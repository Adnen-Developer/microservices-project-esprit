package net.javaguides.facultyservice.service;

import net.javaguides.facultyservice.dto.FacultyDto;

public interface FacultyService {

    FacultyDto saveFaculty(FacultyDto facultyDto);


    FacultyDto getFacultyByCode(String facultyCode);
}
