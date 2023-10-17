package lk.ijse.gdse63.vehicle_micro_service.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleAPI {
    @GetMapping
    public ResponseEntity searchVehicle(){
        return new ResponseEntity("Vehicle", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addVehicle(){
        return new ResponseEntity("Vehicle", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateVehicle(){
        return new ResponseEntity("Vehicle", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteVehicle(){
        return new ResponseEntity("Vehicle", HttpStatus.OK);
    }

}
