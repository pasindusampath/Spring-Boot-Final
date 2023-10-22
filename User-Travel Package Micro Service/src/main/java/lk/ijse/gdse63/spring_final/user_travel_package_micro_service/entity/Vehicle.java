package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicle {
    @Id
    private int vehicleId;

    @ManyToOne
    private UserTravelPackage userTravelPackage;
}
