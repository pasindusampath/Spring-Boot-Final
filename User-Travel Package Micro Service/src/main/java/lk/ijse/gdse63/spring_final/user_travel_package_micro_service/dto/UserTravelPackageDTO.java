package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTravelPackageDTO {
    private int id;
    private String packageId;
    private int customerId;
    private ArrayList<String> places;
    private ArrayList<Integer> hotels;
    private ArrayList<Integer> vehicles;
    private double payment;
}
