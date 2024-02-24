package net.javaguides.facultyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDto {
    private Long id;
    private String facultyName;
    private String facultyDescription;
    private String facultyCode;
}
