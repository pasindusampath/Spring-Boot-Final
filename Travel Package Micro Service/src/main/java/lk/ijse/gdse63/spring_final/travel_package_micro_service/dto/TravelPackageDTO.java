package lk.ijse.gdse63.spring_final.travel_package_micro_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPackageDTO {
    private String id;
    private int hotelCount;
    private int areaCount;
    private double estimatedPrice;
    private String category;
    private int dayCount;
}
