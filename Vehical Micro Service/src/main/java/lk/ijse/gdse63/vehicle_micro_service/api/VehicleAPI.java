package lk.ijse.gdse63.vehicle_micro_service.api;

import lk.ijse.gdse63.vehicle_micro_service.dto.DriverDTO;
import lk.ijse.gdse63.vehicle_micro_service.dto.VehicleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleAPI {
    @GetMapping("/{id:\\d+}")
    public ResponseEntity searchVehicle(@PathVariable String id){
        VehicleDTO vehicleDTO = new VehicleDTO();
        DriverDTO driverDTO = new DriverDTO();
        return new ResponseEntity("Vehicle", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addVehicle(@RequestParam String vehicleName,
                                     @RequestParam String fuelType,
                                     @RequestParam boolean isHybrid,
                                     @RequestParam MultipartFile[] files,
                                     @RequestParam double priceFor1Km,
                                     @RequestParam double fuelUsage,
                                     @RequestParam double priceFor100Km,
                                     @RequestParam int noOfSeats,
                                     @RequestParam String vehicleType,
                                     @RequestParam String category,
                                     @RequestParam String transmission,
                                     @RequestParam String driverName,
                                     @RequestParam String nicNo,
                                     @RequestParam String contactNO,
                                     @RequestParam MultipartFile[] licenceImages,
                                     @RequestParam String remarks){

        System.out.println("Vehicle Name : "+vehicleName);
        System.out.println("Fuel Type : "+fuelType);
        System.out.println("Is Hybrid : "+isHybrid);
        System.out.println("Files : "+files.length);
        System.out.println("Price For 1 Km : "+priceFor1Km);
        System.out.println("Fuel Usage : "+fuelUsage);
        System.out.println("Price For 100 Km : "+priceFor100Km);
        System.out.println("No Of Seats : "+noOfSeats);
        System.out.println("Vehicle Type : "+vehicleType);
        System.out.println("Category : "+category);
        System.out.println("Transmission : "+transmission);
        System.out.println("Driver Name : "+driverName);
        System.out.println("NIC No : "+nicNo);
        System.out.println("Contact No : "+contactNO);
        System.out.println("Licence Images : "+licenceImages.length);
        System.out.println("Remarks : "+remarks);


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
