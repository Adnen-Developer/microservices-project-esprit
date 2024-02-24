package microservice.esprit.tn.etudiantservice.service.Impl;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import microservice.esprit.tn.etudiantservice.dto.APIResponseDto;
import microservice.esprit.tn.etudiantservice.dto.ClasseDto;
import microservice.esprit.tn.etudiantservice.dto.EtudiantDto;
import microservice.esprit.tn.etudiantservice.dto.EvenementDto;
import microservice.esprit.tn.etudiantservice.entity.Etudiant;
import microservice.esprit.tn.etudiantservice.mapper.EtudiantMapper;
import microservice.esprit.tn.etudiantservice.repository.EtudiantRepository;
import microservice.esprit.tn.etudiantservice.service.APIClient;
import microservice.esprit.tn.etudiantservice.service.EtudiantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EtudiantServiceImpl.class);

    private EtudiantRepository etudiantRepository;

    // private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EtudiantDto saveEtudiant(EtudiantDto etudiantDto) {

        Etudiant etudiant = EtudiantMapper.mapToEtudiant(etudiantDto);

        Etudiant saveEtudiant = etudiantRepository.save(etudiant);

        EtudiantDto savedEtudiantDto = EtudiantMapper.mapToEtudiantDto(saveEtudiant);

        return savedEtudiantDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultClasse")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultClasse")
    @Override
    public APIResponseDto getEtudiantById(Long etudiantId) {

        LOGGER.info("inside getEtudiantById() method");
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();

//        ResponseEntity<ClasseDto> responseEntity = restTemplate.getForEntity("http://CLASSE-SERVICE/api/classe/" + etudiant.getDepartmentCode(),
//                ClasseDto.class);
//
//        ClasseDto classeDto = responseEntity.getBody();

        ClasseDto classeDto = webClient.get()
                .uri("http://localhost:8080/api/classes/" + etudiant.getClasseCode())
                .retrieve()
                .bodyToMono(ClasseDto.class)
                .block();

        //  ClasseDto classeDto = apiClient.getDepartment(etudiant.getDepartmentCode());

        EvenementDto evenementDto = webClient.get()
                .uri("http://localhost:8083/api/evenements/" + etudiant.getEvenementCode())
                .retrieve()
                .bodyToMono(EvenementDto.class)
                .block();

        EtudiantDto etudiantDto = EtudiantMapper.mapToEtudiantDto(etudiant);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEtudiant(etudiantDto);
        apiResponseDto.setClasse(classeDto);
        apiResponseDto.setEvenement(evenementDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaulClasse(Long etudiantId, Exception exception) {

        LOGGER.info("inside getDefaultDepartment() method");

        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();

        ClasseDto classeDto = new ClasseDto();
        classeDto.setClasseName("R&D Classe");
        classeDto.setClasseCode("RD001");
        classeDto.setClasseDescription("Research and Development Classe");

        EtudiantDto etudiantDto = EtudiantMapper.mapToEtudiantDto(etudiant);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEtudiant(etudiantDto);
        apiResponseDto.setClasse(classeDto);
        return apiResponseDto;
    }
}
