package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private int userTravelPackageId;
    private byte[] paymentSlip;
    private double amount;
    private boolean isApproved;

}
