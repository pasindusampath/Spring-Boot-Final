package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int vehicleId;

    @ManyToOne
    private UserTravelPackage userTravelPackage;
}
