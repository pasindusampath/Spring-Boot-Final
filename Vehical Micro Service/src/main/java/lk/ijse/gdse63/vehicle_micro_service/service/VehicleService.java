package lk.ijse.gdse63.vehicle_micro_service.service;

import lk.ijse.gdse63.vehicle_micro_service.dto.DriverDTO;
import lk.ijse.gdse63.vehicle_micro_service.dto.VehicleDTO;
import lk.ijse.gdse63.vehicle_micro_service.exception.NotFoundException;
import lk.ijse.gdse63.vehicle_micro_service.exception.SaveFailException;

import java.util.List;

public interface VehicleService {
    int saveVehicle(VehicleDTO dto) throws SaveFailException;

    VehicleDTO searchVehicle(int id) throws NotFoundException;

    List<VehicleDTO> searchByCategory(String category) throws NotFoundException;

}
