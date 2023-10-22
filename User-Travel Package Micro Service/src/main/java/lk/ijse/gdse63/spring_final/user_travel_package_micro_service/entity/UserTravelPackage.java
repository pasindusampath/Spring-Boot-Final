package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private int id;
    private String packageId;
    private int customerId;
    @ToString.Exclude
    @OneToMany(mappedBy = "userTravelPackage")
    private List<Place> places;
    @ToString.Exclude
    @OneToMany(mappedBy = "userTravelPackage")
    private List<Vehicle> vehicles;
    @ToString.Exclude
    @OneToMany(mappedBy = "userTravelPackage")
    private List<Hotel> hotels;
    @OneToMany(mappedBy = "userTravelPackage")
    @ToString.Exclude
    private List<Payment> payments;

}
