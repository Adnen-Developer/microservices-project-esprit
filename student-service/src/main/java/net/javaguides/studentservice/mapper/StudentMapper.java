package net.javaguides.studentservice.mapper;

import net.javaguides.studentservice.dto.StudentDto;
import net.javaguides.studentservice.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getFacultyCode(),
                student.getClubCode()
        );
        return studentDto;
    }

    public static Student mapToStudent(StudentDto studentDto){
        Student student = new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail(),
                studentDto.getFacultyCode(),
                studentDto.getClubCode()
        );
        return student;
    }
}
