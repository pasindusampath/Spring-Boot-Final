package lk.ijse.gdse63.vehicle_micro_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    private int id;
    private String name;
    private String contact;
    private String nic;
    private String remarks;
    private byte[] licenseImageFront;
    private byte[] licenseImageRear;
}
