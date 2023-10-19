package lk.ijse.gdse63.hotel_micro_service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelMicroServiceApplication.class, args);
    }

    @Bean
    public Gson getGson(){
        return new Gson();
    }
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
