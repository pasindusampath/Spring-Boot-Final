package lk.ijse.gdse63.vehicle_micro_service.repo;

import lk.ijse.gdse63.vehicle_micro_service.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepo extends CrudRepository<Vehicle,Integer> {
}
