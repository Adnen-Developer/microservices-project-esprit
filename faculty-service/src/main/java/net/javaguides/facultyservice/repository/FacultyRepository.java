package net.javaguides.facultyservice.repository;

import net.javaguides.facultyservice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty findByFacultyCode(String facultycode);
}
