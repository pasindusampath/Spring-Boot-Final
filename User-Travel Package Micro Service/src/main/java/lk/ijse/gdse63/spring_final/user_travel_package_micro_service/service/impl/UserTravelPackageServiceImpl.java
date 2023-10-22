package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.service.impl;

import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.dto.UserTravelPackageDTO;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.service.UserTravelPackageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserTravelPackageServiceImpl implements UserTravelPackageService {

    private ModelMapper mapper;
    public UserTravelPackageServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }
    public void save(UserTravelPackageDTO ob){
        try {

        }catch (Exception e){

        }
    }
}
