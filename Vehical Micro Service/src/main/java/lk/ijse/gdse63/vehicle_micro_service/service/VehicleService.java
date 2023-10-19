package lk.ijse.gdse63.vehicle_micro_service.service;

import lk.ijse.gdse63.vehicle_micro_service.dto.DriverDTO;
import lk.ijse.gdse63.vehicle_micro_service.dto.VehicleDTO;
import lk.ijse.gdse63.vehicle_micro_service.exception.DeleteFailException;
import lk.ijse.gdse63.vehicle_micro_service.exception.NotFoundException;
import lk.ijse.gdse63.vehicle_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.vehicle_micro_service.exception.UpdatefailException;

import java.util.List;

public interface VehicleService {
    int saveVehicle(VehicleDTO dto) throws SaveFailException;

    VehicleDTO searchVehicle(int id) throws NotFoundException;

    List<VehicleDTO> searchByCategory(String category) throws NotFoundException;

    void updateVehicle(VehicleDTO dto) throws UpdatefailException;

    void deleteVehicle(int id) throws NotFoundException, DeleteFailException;

}
