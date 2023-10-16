package lk.ijse.gdse63.hotel_micro_service.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelApi {
    @GetMapping
    public void getHotel(){
        System.out.println("Get Mapping");
    }

    @PostMapping
    public void save(){
        System.out.println("Post Mapping");
    }

    @PutMapping
    public void update(){
        System.out.println("Put Mapping");
    }

    @DeleteMapping
    public void delete(){
        System.out.println("Delete Mapping");
    }
}
