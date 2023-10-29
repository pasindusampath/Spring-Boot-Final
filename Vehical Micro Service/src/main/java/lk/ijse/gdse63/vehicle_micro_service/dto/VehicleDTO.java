package lk.ijse.gdse63.vehicle_micro_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private int id;
    private String name;
    private String fuelType;
    private boolean isHybrid;
    private ArrayList<byte[]> images;
    private double priceFor1Km;
    private double fuelUsage;
    private double priceFor100Km;
    private int seatCapacity;
    private String vehicleType;
    private String category;
    private String transmission;
    private ArrayList<Integer> removed;

    private DriverDTO driverDTO;
}
