package lk.ijse.gdse63.vehicle_micro_service.api;

import lk.ijse.gdse63.vehicle_micro_service.dto.DriverDTO;
import lk.ijse.gdse63.vehicle_micro_service.dto.VehicleDTO;
import lk.ijse.gdse63.vehicle_micro_service.exception.NotFoundException;
import lk.ijse.gdse63.vehicle_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.vehicle_micro_service.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleAPI {
    VehicleService vehicleService;

    public VehicleAPI(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity searchVehicle(@PathVariable int id) {
        try {
            VehicleDTO vehicleDTO = vehicleService.searchVehicle(id);
            return new ResponseEntity(vehicleDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity addVehicle(@RequestParam String vehicleName,
                                     @RequestParam String fuelType,
                                     @RequestParam boolean isHybrid,
                                     @RequestParam ArrayList<MultipartFile> files,
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
                                     @RequestPart byte[] licenceImageFront,
                                     @RequestPart byte[] licenceImageRear,
                                     @RequestParam String remarks) {

        VehicleDTO vehicleDTO = new VehicleDTO();
        DriverDTO driverDTO = new DriverDTO();
        ArrayList<byte[]> objects = new ArrayList<>();
        files.stream().forEach(file -> {
            try {
                objects.add(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        vehicleDTO.setDriverDTO(driverDTO);
        vehicleDTO.setName(vehicleName);
        vehicleDTO.setFuelType(fuelType);
        vehicleDTO.setHybrid(isHybrid);
        vehicleDTO.setPriceFor1Km(priceFor1Km);
        vehicleDTO.setFuelUsage(fuelUsage);
        vehicleDTO.setPriceFor100Km(priceFor100Km);
        vehicleDTO.setSeatCapacity(noOfSeats);
        vehicleDTO.setVehicleType(vehicleType);
        vehicleDTO.setCategory(category);
        vehicleDTO.setTransmission(transmission);
        vehicleDTO.setImages(objects);
        driverDTO.setName(driverName);
        driverDTO.setNic(nicNo);
        driverDTO.setContact(contactNO);
        driverDTO.setLicenseImageFront(licenceImageFront);
        driverDTO.setLicenseImageRear(licenceImageRear);
        driverDTO.setRemarks(remarks);

        int i = 0;
        try {
            i = vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity(i, HttpStatus.CREATED);
        } catch (SaveFailException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity updateVehicle(@PathVariable int id,
                                        @RequestParam String vehicleName,
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
                                        @RequestParam String remarks) {
        return new ResponseEntity("Vehicle", HttpStatus.OK);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity deleteVehicle(@PathVariable int id) {
        return new ResponseEntity("Vehicle", HttpStatus.OK);
    }

}
