package tn.esprit.core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Notification {
    private String message;
    private String title;
    private Long employeeId;
}
