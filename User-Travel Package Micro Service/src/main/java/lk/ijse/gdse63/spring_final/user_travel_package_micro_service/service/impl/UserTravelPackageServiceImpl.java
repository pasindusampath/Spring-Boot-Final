package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.service.impl;

import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.dto.UserTravelPackageDTO;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity.Hotel;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity.Place;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity.UserTravelPackage;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.entity.Vehicle;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.repo.UserTravelPackageRepo;
import lk.ijse.gdse63.spring_final.user_travel_package_micro_service.service.UserTravelPackageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserTravelPackageServiceImpl implements UserTravelPackageService {

    private ModelMapper mapper;
    private UserTravelPackageRepo repo;
    public UserTravelPackageServiceImpl(ModelMapper mapper, UserTravelPackageRepo repo) {
        this.mapper = mapper;
        this.repo = repo;
    }
    public int save(UserTravelPackageDTO ob) throws SaveFailException {
        try {
            UserTravelPackage map = mapper.map(ob, UserTravelPackage.class);
            map.setHotels(ob.getHotels().stream().map(e->{
                Hotel hotel = new Hotel();
                hotel.setHotelId(e);
                hotel.setUserTravelPackage(map);
                return hotel;
            }).collect(Collectors.toList()));
            map.setPlaces(ob.getPlaces().stream().map(e->{
                Place place = new Place();
                place.setPlace(e);
                place.setUserTravelPackage(map);
                return place;
            }).collect(Collectors.toList()));
            map.setVehicles(ob.getVehicles().stream().map(e->{
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(e);
                vehicle.setUserTravelPackage(map);
                return vehicle;
            }).collect(Collectors.toList()));
            UserTravelPackage save = repo.save(map);
            return save.getId();
        }catch (Exception e){
            throw new SaveFailException("Operation Fail",e);
        }
    }
}
