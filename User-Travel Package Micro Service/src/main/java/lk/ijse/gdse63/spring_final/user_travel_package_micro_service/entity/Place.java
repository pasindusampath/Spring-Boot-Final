package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Place {
    @Id
    private int id;
    private String place;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserTravelPackage userTravelPackage;
}
