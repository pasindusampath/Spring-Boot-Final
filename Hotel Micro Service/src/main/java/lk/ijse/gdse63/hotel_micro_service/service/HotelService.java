package lk.ijse.gdse63.hotel_micro_service.service;

import lk.ijse.gdse63.hotel_micro_service.dto.HotelDTO;
import lk.ijse.gdse63.hotel_micro_service.exception.SaveFailException;
import lk.ijse.gdse63.hotel_micro_service.exception.UpdateFailException;

public interface HotelService {
    int save(HotelDTO hotelDTO) throws SaveFailException;
    void update(HotelDTO hotelDTO) throws UpdateFailException;
}
