package tn.esprit.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Find projects by employee ID stored in the list
    @Query("SELECT p FROM Project p JOIN p.assignedEmployees e WHERE e = :employeeId")
    List<Project> findProjectsByEmployeeId(Long employeeId);
}