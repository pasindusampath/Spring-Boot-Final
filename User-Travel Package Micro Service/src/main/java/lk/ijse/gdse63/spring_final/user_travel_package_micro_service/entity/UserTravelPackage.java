package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String packageId;
    private int customerId;
    @ToString.Exclude
    @OneToMany(mappedBy = "userTravelPackage",cascade = CascadeType.ALL)
    private List<Place> places;
    @ToString.Exclude
    @OneToMany(mappedBy = "userTravelPackage" , cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;
    @ToString.Exclude
    @OneToMany(mappedBy = "userTravelPackage" , cascade = CascadeType.ALL)
    private List<Hotel> hotels;
    @OneToMany(mappedBy = "userTravelPackage" , cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Payment> payments;

}
