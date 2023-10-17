package lk.ijse.gdse63.vehicle_micro_service.api;

import lk.ijse.gdse63.vehicle_micro_service.dto.VehicleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleAPI {
    @GetMapping("/{id:^0$}")
    public ResponseEntity searchVehicle(@RequestParam String name,
                                        @RequestParam String fuelType,
                                        @RequestParam boolean isHybrid,
                                        @RequestParam MultipartFile[] files,
                                        @RequestParam double priceFor1Km,
                                        @RequestParam double fuelUsage,
                                        @RequestParam double priceFor100Km,
                                        @RequestParam int noOfSeats,
                                        @RequestParam String vehicleType,
                                        @RequestParam String category,
                                        @RequestParam String transmission){
        VehicleDTO vehicleDTO = new VehicleDTO();

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
