package net.javaguides.doctorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CabinetDto {
    private Long id;
    private String cabinetName;
    private String cabinetDescription;
    private String cabinetCode;
}
