package lk.ijse.gdse63.vehicle_micro_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contact;
    private String nic;
    private String remarks;
    private String licenseImageFront;
    private String licenseImageRear;

    @OneToOne(targetEntity = Vehicle.class , mappedBy = "driver")
    private Vehicle vehicle;
}
