package lk.ijse.gdse63.spring_final.travel_package_micro_service.repo;

import lk.ijse.gdse63.spring_final.travel_package_micro_service.entity.TravelPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelPackageRepo extends CrudRepository<TravelPackage, String> {
    List<TravelPackage> findByCategory(String category);
}
