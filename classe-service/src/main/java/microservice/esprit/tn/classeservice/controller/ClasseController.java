package microservice.esprit.tn.classeservice.controller;

import lombok.AllArgsConstructor;
import microservice.esprit.tn.classeservice.dto.ClasseDto;
import microservice.esprit.tn.classeservice.service.ClasseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/classes")
@AllArgsConstructor
public class ClasseController {
    private ClasseService classeService;

    // Build save classe REST API
    @PostMapping
    public ResponseEntity<ClasseDto> saveClasse(@RequestBody ClasseDto classeDto){
        ClasseDto savedClasse = classeService.saveClasse(classeDto);
        return new ResponseEntity<>(savedClasse, HttpStatus.CREATED);
    }

    // Build get classe rest api
    @GetMapping("{classe-code}")
    public ResponseEntity<ClasseDto> getDepartment(@PathVariable("classe-code") String classeCode){
        ClasseDto classeDto = classeService.getClasseByCode(classeCode);
        return new ResponseEntity<>(classeDto, HttpStatus.OK);
    }
}
