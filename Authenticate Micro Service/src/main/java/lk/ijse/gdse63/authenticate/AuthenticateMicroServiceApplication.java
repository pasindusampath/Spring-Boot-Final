package lk.ijse.gdse63.authenticate;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthenticateMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticateMicroServiceApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
