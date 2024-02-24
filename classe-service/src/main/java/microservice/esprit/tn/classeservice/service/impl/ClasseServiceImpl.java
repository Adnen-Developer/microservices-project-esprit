package microservice.esprit.tn.classeservice.service.impl;

import lombok.AllArgsConstructor;
import microservice.esprit.tn.classeservice.dto.ClasseDto;
import microservice.esprit.tn.classeservice.entity.Classe;
import microservice.esprit.tn.classeservice.mapper.ClasseMapper;
import microservice.esprit.tn.classeservice.repository.ClasseRepository;
import microservice.esprit.tn.classeservice.service.ClasseService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClasseServiceImpl implements ClasseService {
    private ClasseRepository classeRepository;

    @Override
    public ClasseDto saveClasse(ClasseDto classeDto) {

        // convert department dto to department jpa entity
        Classe classe = ClasseMapper.mapToClasse(classeDto);

        Classe savedClasse= classeRepository.save(classe);

        ClasseDto savedClasseDto = ClasseMapper.mapToClasseDto(savedClasse);

        return savedClasseDto;
    }

    @Override
    public ClasseDto getClasseByCode(String classeCode) {

        Classe classe = classeRepository.findByClasseCode(classeCode);

        ClasseDto classeDto = ClasseMapper.mapToClasseDto(classe);

        return classeDto;
    }
}
