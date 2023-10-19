package lk.ijse.gdse63.vehicle_micro_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String fuelType;
    private boolean isHybrid;
    @Column(columnDefinition = "TEXT")
    private String images;
    private double priceFor1Km;
    private double fuelUsage;
    private double priceFor100Km;
    private int seatCapacity;
    private String vehicleType;
    private String category;
    private String transmission;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Driver driver;
}
