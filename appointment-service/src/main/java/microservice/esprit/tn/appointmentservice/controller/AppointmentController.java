package microservice.esprit.tn.appointmentservice.controller;

import lombok.AllArgsConstructor;
import microservice.esprit.tn.appointmentservice.dto.AppointmentDto;
import microservice.esprit.tn.appointmentservice.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/appointments")
@AllArgsConstructor
public class AppointmentController {
    private AppointmentService appointmentService ;

    // Build Save Organization REST API
    @PostMapping
    public ResponseEntity<AppointmentDto> saveAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto savedAppointment = appointmentService.saveAppointment(appointmentDto);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    // Build Get Organization by Code REST API
    @GetMapping("{code}")
    public ResponseEntity<AppointmentDto> getAppointment(@PathVariable("code") String appointmentCode){
        AppointmentDto appointmentDto = appointmentService.getAppointmentByCode(appointmentCode);
        return ResponseEntity.ok(appointmentDto);
    }
}
