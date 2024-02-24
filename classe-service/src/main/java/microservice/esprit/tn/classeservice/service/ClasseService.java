package microservice.esprit.tn.classeservice.service;

import microservice.esprit.tn.classeservice.dto.ClasseDto;

public interface ClasseService {
    ClasseDto saveClasse(ClasseDto classeDto);

    ClasseDto getClasseByCode(String code);
}
