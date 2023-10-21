package lk.ijse.gdse63.spring_final.travel_package_micro_service.service.impl;

import lk.ijse.gdse63.spring_final.travel_package_micro_service.dto.TravelPackageDTO;
import lk.ijse.gdse63.spring_final.travel_package_micro_service.service.TravelPackageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPackageServiceIMPL implements TravelPackageService {
    @Override
    public String save(TravelPackageDTO obj) {
        System.out.println(obj);
        return "NEXT-0001";
    }

    @Override
    public void update(TravelPackageDTO obj) {
        System.out.println(obj);
    }

    @Override
    public void delete(String id) {
        System.out.println(id);
    }

    @Override
    public List<TravelPackageDTO> getPackagesByCategory(String category) {
        return null;
    }
}
