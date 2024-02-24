package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class CongeEvaluatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CongeEvaluatorServiceApplication.class, args);
	}

}
