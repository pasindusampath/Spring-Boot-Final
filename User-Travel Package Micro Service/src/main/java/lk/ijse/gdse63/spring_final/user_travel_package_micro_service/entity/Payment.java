package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
    @Id
    private int id;
    private String paymentSlip;
    private double amount;
    private boolean isApproved;
    @ManyToOne
    private UserTravelPackage userTravelPackage;
}
