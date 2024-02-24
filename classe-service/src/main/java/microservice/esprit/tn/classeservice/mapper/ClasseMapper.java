package microservice.esprit.tn.classeservice.mapper;

import microservice.esprit.tn.classeservice.dto.ClasseDto;
import microservice.esprit.tn.classeservice.entity.Classe;

public class ClasseMapper {
    public static ClasseDto mapToClasseDto(Classe classe){
        ClasseDto classeDto = new ClasseDto(
                classe.getId(),
                classe.getClasseName(),
                classe.getClaaseDescription(),
                classe.getClasseCode()
        );
        return classeDto;
    }

    public static Classe mapToClasse(ClasseDto classeDto){
        Classe classe = new Classe(
                classeDto.getId(),
                classeDto.getClasseName(),
                classeDto.getClasseDescription(),
                classeDto.getClasseCode()
        );
        return classe;
    }
}
