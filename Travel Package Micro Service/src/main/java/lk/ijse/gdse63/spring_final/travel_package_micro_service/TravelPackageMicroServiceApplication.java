package lk.ijse.gdse63.spring_final.travel_package_micro_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelPackageMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelPackageMicroServiceApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
