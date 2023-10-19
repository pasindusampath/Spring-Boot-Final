package lk.ijse.gdse63.vehicle_micro_service.repo;

import lk.ijse.gdse63.vehicle_micro_service.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepo extends CrudRepository<Vehicle,Integer> {
    List<Vehicle> findByCategory(String category);
}
