package tn.esprit.core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employeeId; // Assume each employee has a unique employee ID

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;

    @Column(length = 500) // Max 500 characters for the reason
    private String reason;

    @Column(nullable = true)
    private String status; // e.g., "APPROVED", "PENDING", "DENIED"

}
