package lk.ijse.gdse63.spring_final.travel_package_micro_service.service;

import lk.ijse.gdse63.spring_final.travel_package_micro_service.dto.TravelPackageDTO;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.exception.DeleteFailException;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.exception.UpdateFailException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TravelPackageService {

    public String save(TravelPackageDTO obj) throws SaveFailException;
    void update(TravelPackageDTO obj) throws UpdateFailException;
    void delete(String id) throws DeleteFailException;
    List<TravelPackageDTO> getPackagesByCategory(String category);
    TravelPackageDTO fidById(String id);
    List<TravelPackageDTO> findByCategory(String category);
    String generateNextId();
}
