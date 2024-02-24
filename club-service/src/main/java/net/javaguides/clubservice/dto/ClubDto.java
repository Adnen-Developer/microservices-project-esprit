package net.javaguides.clubservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClubDto {
    private Long id;
    private String clubName;
    private String clubDescription;
    private String clubCode;
    private LocalDateTime createdDate;
}
