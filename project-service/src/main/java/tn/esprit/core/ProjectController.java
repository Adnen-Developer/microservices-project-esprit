package tn.esprit.core;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final KafkaTemplate<String, Notification> kafkaTemplate;

    // Add a new project
    @PostMapping("/")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project newProject = projectRepository.save(project);
        return ResponseEntity.ok(newProject);
    }

    // Assign an employee to a project
    @PutMapping("/{projectId}/assign/{employeeId}")
    public ResponseEntity<Project> assignEmployeeToProject(@PathVariable Long projectId, @PathVariable Long employeeId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (!projectOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Project project = projectOptional.get();
        List<Long> assignedEmployees = project.getAssignedEmployees();

        // Check if employeeId already assigned to avoid duplicates
        if (!assignedEmployees.contains(employeeId)) {
            assignedEmployees.add(employeeId);
            project.setAssignedEmployees(assignedEmployees);
            Project updatedProject = projectRepository.save(project);
            return ResponseEntity.ok(updatedProject);
        }
        Notification notification = new Notification();
        notification.setTitle("Employé ajouté");
        notification.setMessage("Un employé a été ajouté");
        notification.setEmployeeId(employeeId);
        kafkaTemplate.send("NotificationTopic",notification);
        // If already assigned, just return the current state without changes
        return ResponseEntity.ok(project);
    }


    // Get a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return projectRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Get projects by employee ID
    @GetMapping("/employee/{employeeId}")
    public List<Project> getProjectsByEmployeeId(@PathVariable Long employeeId) {
        return projectRepository.findProjectsByEmployeeId(employeeId);
    }



}
