package lk.ijse.gdse63.vehicle_micro_service.service;

import lk.ijse.gdse63.vehicle_micro_service.dto.DriverDTO;
import lk.ijse.gdse63.vehicle_micro_service.dto.VehicleDTO;

public interface VehicleService {
    int saveVehicle(VehicleDTO dto);
}
