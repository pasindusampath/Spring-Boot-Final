package lk.ijse.gdse63.spring_final.travel_package_micro_service.api;

import lk.ijse.gdse63.spring_final.travel_package_micro_service.dto.TravelPackageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/travel-package")
public class TravelPackageApi {
    @PostMapping
    public ResponseEntity save(@RequestBody TravelPackageDTO obj){

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(){
        return ResponseEntity.ok().build();
    }

}
