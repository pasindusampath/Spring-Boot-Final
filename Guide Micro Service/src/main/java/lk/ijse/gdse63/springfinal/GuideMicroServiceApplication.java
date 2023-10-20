package lk.ijse.gdse63.springfinal;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GuideMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuideMicroServiceApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public Gson getGson(){
        return new Gson();
    }

}
