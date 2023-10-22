package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.service;

import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.dto.UserTravelPackageDTO;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.exception.SaveFailException;
import org.springframework.stereotype.Service;


public interface UserTravelPackageService {
    int save(UserTravelPackageDTO ob) throws SaveFailException;

}
