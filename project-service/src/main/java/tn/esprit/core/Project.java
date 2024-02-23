package tn.esprit.core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "budget")
    private Integer budget;

    // New attributes
    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status = "ON_GOING";


    @ElementCollection
    @CollectionTable(name = "project_assigned_employees", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "employee_id")
    private List<Long> assignedEmployees = new ArrayList<>();
}
