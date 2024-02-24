package net.javaguides.facultyservice.mapper;

import net.javaguides.facultyservice.dto.FacultyDto;
import net.javaguides.facultyservice.entity.Faculty;

public class FacultyMapper {

    public static FacultyDto mapToFacultyDto(Faculty faculty){
        FacultyDto facultyDto = new FacultyDto(
                faculty.getId(),
                faculty.getFacultyName(),
                faculty.getFacultyDescription(),
                faculty.getFacultyCode()
        );
        return facultyDto;
    }

    public static Faculty mapToFaculty(FacultyDto facultyDto){
        Faculty faculty = new Faculty(
                facultyDto.getId(),
                facultyDto.getFacultyName(),
                facultyDto.getFacultyDescription(),
                facultyDto.getFacultyCode()
        );
        return faculty;
    }
}
